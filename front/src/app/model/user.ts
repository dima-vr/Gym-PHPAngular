import {UserRole} from "./user-role";
import {Goal} from "./goals";


export class User {
  constructor(
    public id?: number,
    public email?: string,
    public password?: string,
    public role?: UserRole,
    public profilePhotoUrl?: string,
    public height?: number,
    public weight?: number,
    public paymentStatus?: boolean,
    public goals?: Goal[],
    ) {
  }

  public static fromObjectToModel(user: any): User {
    return new User(
      user.id,
      user.email,
      user.password,
      user.role,
      user.profilePhotoUrl,
      user.height,
      user.weight,
      user.paymentStatus,
      user.goals,
    );
  }

  public isAdmin(): boolean {
    return this.role == UserRole.ADMIN;
  }
}
