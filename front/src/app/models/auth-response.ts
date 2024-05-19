import {RoleModel} from "./role.model";
import {User} from "./user.model";


export class AuthResponse {
  public token: string;
  public refreshToken: string;
  public accessTokenLifetimeMinutes: number;
  public refreshTokenLifetimeMinutes: number;
  public role: RoleModel;
  public user: User;

  constructor(token: string, refreshToken: string, accessTokenLifetimeMinutes: number, refreshTokenLifetimeMinutes: number, role: RoleModel, user: User) {
    this.token = token;
    this.refreshToken = refreshToken;
    this.accessTokenLifetimeMinutes = accessTokenLifetimeMinutes;
    this.refreshTokenLifetimeMinutes = refreshTokenLifetimeMinutes;
    this.role = role;
    this.user = user;
  }
}
