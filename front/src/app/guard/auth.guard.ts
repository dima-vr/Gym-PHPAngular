import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Observable, of} from 'rxjs';
import {AuthenticationService} from '../service/authentication.service';
import {catchError, map} from 'rxjs/operators';
import {User} from "../model/user";

@Injectable({providedIn: 'root'})
export class AuthGuard implements CanActivate {

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    return this.authenticationService.getUserByToken().pipe(
      //@ts-ignore+
      map((user: User) => {
        console.log(user);
        console.log(state);
        if (user === null) {
          this.router.navigateByUrl('/login');
          return false;
        } else if (!user.isAdmin()) {
          this.router.navigateByUrl('/login');
          return false;
        } else {
          return true;
        }
      }),
      catchError((error: any) => {
        console.log(error);
        this.router.navigateByUrl('/login');
        return of(false);
      })
    );
  }
}
