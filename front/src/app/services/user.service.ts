import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { UserModel } from '../models/user.model';

const API_URL = environment.apiUrl + '/users';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAllUsers() {
    return this.http.get(API_URL);
  }

  getUserById(id: number) {
    return this.http.get(API_URL + '/' + id);
  }

  createUser(user: UserModel) {
    return this.http.post(API_URL, user);
  }

  updateUser(id: number, user: UserModel) {
    return this.http.put(`${API_URL}/${id}`, user);
  }

  deleteUser(id: number) {
    return this.http.delete(`${API_URL}/${id}`);
  }
}
