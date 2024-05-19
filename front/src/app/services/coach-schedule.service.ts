import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { CoachScheduleModel } from '../models/coach-schedule.model';

const API_URL = environment.apiUrl + '/coachSchedule';

@Injectable({
  providedIn: 'root'
})
export class CoachScheduleService {

  constructor(private http: HttpClient) { }

  getAllCoachSchedules() {
    return this.http.get(API_URL);
  }

  getCoachScheduleById(id: number) {
    return this.http.get(API_URL + '/' + id);
  }

  createCoachSchedule(coachSchedule: CoachScheduleModel) {
    return this.http.post(API_URL, coachSchedule);
  }

  updateCoachSchedule(id: number, coachSchedule: CoachScheduleModel) {
    return this.http.put(`${API_URL}/${id}`, coachSchedule);
  }

  deleteCoachSchedule(id: number) {
    return this.http.delete(`${API_URL}/${id}`);
  }
}
