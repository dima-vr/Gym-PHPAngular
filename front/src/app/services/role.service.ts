import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { RoleModel } from '../models/role.model';

const API_URL = environment.apiUrl + '/roles';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private http: HttpClient) { }

  getAllRoles() {
    return this.http.get(API_URL);
  }

  getRoleById(id: number) {
    return this.http.get(API_URL + '/' + id);
  }

  createRole(role: RoleModel) {
    return this.http.post(API_URL, role);
  }

  updateRole(id: number, role: RoleModel) {
    return this.http.put(`${API_URL}/${id}`, role);
  }

  deleteRole(id: number) {
    return this.http.delete(`${API_URL}/${id}`);
  }
}
