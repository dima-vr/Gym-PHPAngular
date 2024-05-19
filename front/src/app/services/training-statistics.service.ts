import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { TrainingStatisticsModel } from '../models/training-statistics.model';

const API_URL = environment.apiUrl + '/trainingStatistics';

@Injectable({
  providedIn: 'root'
})
export class TrainingStatisticsService {

  constructor(private http: HttpClient) { }

  getAllTrainingStatistics() {
    return this.http.get(API_URL);
  }

  getTrainingStatisticsById(id: number) {
    return this.http.get(API_URL + '/' + id);
  }

  createTrainingStatistics(trainingStatistics: TrainingStatisticsModel) {
    return this.http.post(API_URL, trainingStatistics);
  }

  updateTrainingStatistics(id: number, trainingStatistics: TrainingStatisticsModel) {
    return this.http.put(`${API_URL}/${id}`, trainingStatistics);
  }

  deleteTrainingStatistics(id: number) {
    return this.http.delete(`${API_URL}/${id}`);
  }
}
