import {UserRole} from "./user-role";
import {User} from "./user";


export class AuthResponse {
  public token: string;
  public refreshToken: string;
  public accessTokenLifetimeMinutes: number;
  public refreshTokenLifetimeMinutes: number;
  public role: UserRole;
  public user: User;

  constructor(token: string, refreshToken: string, accessTokenLifetimeMinutes: number, refreshTokenLifetimeMinutes: number, role: UserRole, user: User) {
    this.token = token;
    this.refreshToken = refreshToken;
    this.accessTokenLifetimeMinutes = accessTokenLifetimeMinutes;
    this.refreshTokenLifetimeMinutes = refreshTokenLifetimeMinutes;
    this.role = role;
    this.user = user;
  }
}
