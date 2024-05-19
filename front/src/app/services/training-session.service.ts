import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { TrainingSessionModel } from '../models/training-session.model';

const API_URL = environment.apiUrl + '/trainingSessions';

@Injectable({
  providedIn: 'root'
})
export class TrainingSessionService {

  constructor(private http: HttpClient) { }

  getAllTrainingSessions() {
    return this.http.get(API_URL);
  }

  getTrainingSessionById(id: number) {
    return this.http.get(API_URL + '/' + id);
  }

  createTrainingSession(trainingSession: TrainingSessionModel) {
    return this.http.post(API_URL, trainingSession);
  }

  updateTrainingSession(id: number, trainingSession: TrainingSessionModel) {
    return this.http.put(`${API_URL}/${id}`, trainingSession);
  }

  deleteTrainingSession(id: number) {
    return this.http.delete(`${API_URL}/${id}`);
  }
}
