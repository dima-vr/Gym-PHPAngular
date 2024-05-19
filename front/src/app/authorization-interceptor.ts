import {Injectable} from '@angular/core';

import {BehaviorSubject, Observable, throwError} from 'rxjs';
import {catchError, filter, switchMap, take} from "rxjs/operators";
import {Router} from '@angular/router';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {AuthenticationService} from "./services/authentication.service";
import {environment} from "../environments/environment";


@Injectable({
  providedIn: 'root'
})
export class AuthorizationInterceptor implements HttpInterceptor {

  isRefreshingNow = false;
  refreshInProgress$ = new BehaviorSubject(null);

  constructor(private authenticationService: AuthenticationService,
              private router: Router) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (request.url.includes(`${environment.api_url}`)) {
      const authHeader = this.getAuthHeader();

      if (authHeader && !request.url.includes(environment.api_url + '/refresh') && !request.url.includes(environment.api_url + '/login')) {
        request = this.addTokenToHeader(request, authHeader);
      }
    }
    return next.handle(request)
      .pipe(catchError(error => this.handleError(error, request, next)));
  }

  private handleError(error: HttpErrorResponse, request: HttpRequest<any>, next: HttpHandler): Observable<any> {
    if (error.status === 426) {
      return this.refreshToken(request, next);
    }

    if (error.status === 401) {
      this.router.navigate(['/login']);
      this.authenticationService.clearUserData();
    }

    return throwError(error);
  }

  private refreshToken(request: HttpRequest<any>, next: HttpHandler) {
    if (this.isRefreshingNow) {
      return this.refreshInProgress$
        .pipe(
          filter(token => token != null),
          take(1),
          switchMap(() => this.intercept(request.clone(), next))
        );
    }
    this.isRefreshingNow = true
    this.refreshInProgress$.next(null);
    return this.authenticationService.refreshToken().pipe(
      switchMap((): any => {
        this.isRefreshingNow = false;
        // @ts-ignore
        this.refreshInProgress$.next(false);
        let authHeader = this.getAuthHeader();
        if (authHeader != null) {
          return next.handle(this.addTokenToHeader(request, authHeader));
        }
      }),
      catchError(err => {
        this.isRefreshingNow = false;
        this.router.navigate(['/login']);
        if (err.status === 401) {
          this.authenticationService.clearUserData();
        } else {
          this.authenticationService.logout();
        }
        return throwError(err);
      })
    );
  }

  private getAuthHeader(): string | null {
    return sessionStorage.getItem('authHeader');
  }

  private addTokenToHeader(request: HttpRequest<any>, authHeader: string) {
    return request.clone({setHeaders: {Authorization: authHeader}});
  }

}
