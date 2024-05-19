import { UserModel } from "./user.model";

export class CoachModel {
  id: number;
  user: UserModel;
  skillsAndExperience: string;

  constructor(id: number, user: UserModel, skillsAndExperience: string) {
    this.id = id;
    this.user = user;
    this.skillsAndExperience = skillsAndExperience;
  }
}
