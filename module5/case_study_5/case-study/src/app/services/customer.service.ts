import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private URL_API = 'http://localhost:3000/customers';

  constructor(
    public http: HttpClient
  ) { }

  getAllCustomer(): Observable<any>{
    return this.http.get(this.URL_API);
  }

  addNewCustomer(customer): Observable<any> {
    return this.http.post(this.URL_API, customer);
  }

  getCustomerById(id: number): Observable<any> {
    return this.http.get(`${this.URL_API}/${id}`);
  }

  editCustomer(customer, customerId): Observable<any> {
    return this.http.put(this.URL_API + '/' + customerId, customer);
  }
  deleteCustomer(customerId): Observable<any> {
    return this.http.delete(this.URL_API + '/' + customerId);
  }
}
