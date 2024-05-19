import { CoachModel } from "./coach.model";
import { WorkoutModel } from "./workout.model";

export class TrainingSessionModel {
  id: number;
  coach: CoachModel;
  sessionDate: Date;
  workout: WorkoutModel;

  constructor(id: number, coach: CoachModel, sessionDate: Date, workout: WorkoutModel) {
    this.id = id;
    this.coach = coach;
    this.sessionDate = sessionDate;
    this.workout = workout;
  }
}
