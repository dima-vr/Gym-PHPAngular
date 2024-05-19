export class Goal {
  constructor(
    public id?: number,
    public goals?: string) {
  }

  public static fromObjectToModel(goal: any): Goal {
    return new Goal(
      goal.id,
      goal.goals,
    );
  }
}
