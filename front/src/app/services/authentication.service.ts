import {Injectable} from '@angular/core';
import {map, Observable, tap} from "rxjs";
import {User} from "../models/user.model";
import {HttpClient, HttpParams} from "@angular/common/http";
import {AuthResponse} from "../models/auth-response";
import {environment} from "../../environments/environment";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private authApiUrl = `${environment.api_url}/api/auth`;

  constructor(private http: HttpClient, private router: Router) {
  }

  public login(username: string, password: string): Observable<User> {
    // @ts-ignore
    return this.http.post(this.authApiUrl + "/login", {username, password}).pipe(
      // @ts-ignore
      map((response: AuthResponse) => {
        let user = null;
        if (response && response.token) {
          user = User.fromObjectToModel(response.user);
          user.role = response.role;
          this.updateTokens(response);
        }
        return user;
      }));
  }

  public refreshToken(): Observable<AuthResponse> {
    return this.postRefreshToken('refresh').pipe(tap(token => this.updateTokens(token)));
  }

  public getUserByToken(): Observable<User | null> {
    return this.http.get<User>(this.authApiUrl + "/authenticate").pipe(
      map((response: User) => {
        let user = null;
        if (response && response.id) {
          user = User.fromObjectToModel(response);
          user.role = response.role;
        }
        return user;
      })
    );
  }

  public logout(): void {
    this.clearUserData();
    this.postRefreshToken('logout').subscribe();
    this.router.navigateByUrl("login");
  }

  private postRefreshToken(url: string): Observable<AuthResponse> {
    const refreshToken = localStorage.getItem('refreshToken');
    let params = new HttpParams();
    if (refreshToken != null) {
      params = params.append('refreshToken', refreshToken);
    }
    return this.http.post<AuthResponse>(`${this.authApiUrl}/${url}`, {}, {params})
  }

  public clearUserData(): void {
    sessionStorage.clear();
  }

  private updateTokens(authResponse: AuthResponse): void {
    sessionStorage.setItem('authHeader', `Bearer ${authResponse.token}`);
    localStorage.setItem('refreshToken', `${authResponse.refreshToken}`);
  }
}
