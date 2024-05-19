export class WorkoutModel {
  id: number;
  type: string;
  groupSession: boolean;

  constructor(id: number, type: string, groupSession: boolean) {
    this.id = id;
    this.type = type;
    this.groupSession = groupSession;
  }
}
