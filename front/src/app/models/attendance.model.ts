import { TrainingSessionModel } from "./training-session.model";
import { UserModel } from "./user.model";

export class AttendanceModel {
  id: number;
  session: TrainingSessionModel;
  user: UserModel;

  constructor(id: number, session: TrainingSessionModel, user: UserModel) {
    this.id = id;
    this.session = session;
    this.user = user;
  }
}
