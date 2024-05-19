import { GoalModel } from "./goal.model";
import { RoleModel } from "./role.model";

export class UserModel {
  id: number;
  username: string;
  password: string;
  email: string;
  profilePhotoUrl: string;
  height: number;
  weight: number;
  paymentStatus: boolean;
  goals: GoalModel[];
  role: RoleModel;

  constructor(id: number, username: string, password: string, email: string, profilePhotoUrl: string, height: number, weight: number, paymentStatus: boolean, goals: GoalModel[], role: RoleModel) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.profilePhotoUrl = profilePhotoUrl;
    this.height = height;
    this.weight = weight;
    this.paymentStatus = paymentStatus;
    this.goals = goals;
    this.role = role;
  }
}
