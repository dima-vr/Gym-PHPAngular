import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { GoalModel } from '../models/goal.model';

const API_URL = environment.apiUrl + '/goals';

@Injectable({
  providedIn: 'root'
})
export class GoalService {

  constructor(private http: HttpClient) { }

  getAllGoals() {
    return this.http.get(API_URL);
  }

  getGoalById(id: number) {
    return this.http.get(API_URL + '/' + id);
  }

  createGoal(goal: GoalModel) {
    return this.http.post(API_URL, goal);
  }

  updateGoal(id: number, goal: GoalModel) {
    return this.http.put(`${API_URL}/${id}`, goal);
  }

  deleteGoal(id: number) {
    return this.http.delete(`${API_URL}/${id}`);
  }
}
