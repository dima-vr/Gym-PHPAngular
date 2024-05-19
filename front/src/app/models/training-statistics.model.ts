import { UserModel } from "./user.model";
import { WorkoutModel } from "./workout.model";

export class TrainingStatisticsModel {
  id: number;
  user: UserModel;
  trainingDate: Date;
  workout: WorkoutModel;
  durationMinutes: number;
  achievements: string[];

  constructor(id: number, user: UserModel, trainingDate: Date, workout: WorkoutModel, durationMinutes: number, achievements: string[]) {
    this.id = id;
    this.user = user;
    this.trainingDate = trainingDate;
    this.workout = workout;
    this.durationMinutes = durationMinutes;
    this.achievements = achievements;
  }
}
