export class UserRole {
  constructor(
    public id?: number,
    public name?: string) {
  }

  public static fromObjectToModel(userRole: any): UserRole {
    return new UserRole(
      userRole.id,
      userRole.name,
    );
  }
}
