export class GoalModel {
  id: number;
  goals: string;

  constructor(id: number, goals: string) {
    this.id = id;
    this.goals = goals;
  }
}
