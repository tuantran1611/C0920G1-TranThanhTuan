import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Employee} from '../employee';
import {AngularFireDatabase, AngularFireList} from '@angular/fire/database';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private URL_API = 'http://localhost:8080/employees';

  imageDetailList: AngularFireList<any>;

  constructor(
    public http: HttpClient,
    private firebase: AngularFireDatabase
  ) { }
  // getAllEmployees(): Observable<Employee[]>{
  //   return this.http.get<Employee[]>(this.URL_API);
  // }
  getImageDetailList(){
    this.imageDetailList = this.firebase.list('imageDetails');
  }

  insertImageDetails(imageDetails){
    this.imageDetailList.push(imageDetails);
  }

  getAllEmployees(page: number, size: number, nameSorting: boolean): Observable<any>{
    return this.http.get(this.URL_API + '?page=' + page + '&size=' + size + '&nameSorting=' + nameSorting);
  }

  addNewEmployee(employee): Observable<Employee> {
    return this.http.post<Employee>(this.URL_API, employee);
  }

  getEmployeeById(id: number): Observable<any> {
    return this.http.get(this.URL_API + '/' + id);
  }

  editEmployee(employee, employeeId): Observable<Employee> {
    return this.http.put<Employee>(this.URL_API + '/' + employeeId, employee);
  }
  deleteEmployee(employeeId): Observable<Employee> {
    return this.http.delete<Employee>(this.URL_API + '/' + employeeId);
  }

  getAllEmployeeByName(name: string, size: number): Observable<any>{
    return this.http.get(this.URL_API + '/' + '?name=' + name + '&size=' + size);
  }
}
