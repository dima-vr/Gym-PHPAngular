import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { CoachModel } from '../models/coach.model';

const API_URL = environment.apiUrl + '/coaches';

@Injectable({
  providedIn: 'root'
})
export class CoachService {

  constructor(private http: HttpClient) { }

  getAllCoaches() {
    return this.http.get(API_URL);
  }

  getCoachById(id: number) {
    return this.http.get(API_URL + '/' + id);
  }

  createCoach(coach: CoachModel) {
    return this.http.post(API_URL, coach);
  }

  updateCoach(id: number, coach: CoachModel) {
    return this.http.put(`${API_URL}/${id}`, coach);
  }

  deleteCoach(id: number) {
    return this.http.delete(`${API_URL}/${id}`);
  }
}
