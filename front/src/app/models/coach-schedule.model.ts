import { CoachModel } from "./coach.model";

export class CoachScheduleModel {
  id: number;
  coach: CoachModel;
  dayOfWeek: string;
  startTime: Date;
  endTime: Date;

  constructor(id: number, coach: CoachModel, dayOfWeek: string, startTime: Date, endTime: Date) {
    this.id = id;
    this.coach = coach;
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }
}
