import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { WorkoutModel } from '../models/workout.model';

const API_URL = environment.apiUrl + '/workouts';

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {

  constructor(private http: HttpClient) { }

  getAllWorkouts() {
    return this.http.get(API_URL);
  }

  getWorkoutById(id: number) {
    return this.http.get(API_URL + '/' + id);
  }

  createWorkout(workout: WorkoutModel) {
    return this.http.post(API_URL, workout);
  }

  updateWorkout(id: number, workout: WorkoutModel) {
    return this.http.put(`${API_URL}/${id}`, workout);
  }

  deleteWorkout(id: number) {
    return this.http.delete(`${API_URL}/${id}`);
  }
}
