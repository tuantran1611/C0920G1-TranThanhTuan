import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private URL_API = 'http://localhost:3000/employees';
  private URL_API_1 = 'http://localhost:3000/positions';

  constructor(
    public http: HttpClient
  ) { }

  getAllPositions(): Observable<any>{
    return this.http.get(this.URL_API_1);
  }

  getAllEmployees(): Observable<any>{
    return this.http.get(this.URL_API);
  }

  addNewEmployee(employee): Observable<any> {
    return this.http.post(this.URL_API, employee);
  }

  getEmployeeById(id: number): Observable<any> {
    return this.http.get(`${this.URL_API}/${id}`);
  }

  editEmployee(employee, employeeId): Observable<any> {
    return this.http.put(this.URL_API + '/' + employeeId, employee);
  }
  deleteEmployee(employeeId): Observable<any> {
    return this.http.delete(this.URL_API + '/' + employeeId);
  }
  sort(name: string, direction: string){
    return this.http.get(this.URL_API + '?_sort=' + name + '&_order=' + direction);
  }
  searchByName(name: string) {
    return this.http.get(this.URL_API + '?fullName_like=' + name);
  }
}
