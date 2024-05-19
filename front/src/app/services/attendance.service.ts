import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AttendanceModel } from '../models/attendance.model';

const API_URL = environment.apiUrl + '/attendance';

@Injectable({
  providedIn: 'root'
})
export class AttendanceService {

  constructor(private http: HttpClient) { }

  getAllAttendances() {
    return this.http.get(API_URL);
  }

  getAttendanceById(id: number) {
    return this.http.get(API_URL + '/' + id);
  }

  createAttendance(attendance: AttendanceModel) {
    return this.http.post(API_URL, attendance);
  }

  updateAttendance(id: number, attendance: AttendanceModel) {
    return this.http.put(`${API_URL}/${id}`, attendance);
  }

  deleteAttendance(id: number) {
    return this.http.delete(`${API_URL}/${id}`);
  }
}
