import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SotietkiemService {

  private URL_API = 'http://localhost:3000/sotietkiems';
  private URL_API_1 = 'http://localhost:3000/khachhang';

  constructor(
    public http: HttpClient
  ) { }

  layKhachHang(): Observable<any>{
    return this.http.get(this.URL_API_1);
  }

  laySos(): Observable<any>{
    return this.http.get(this.URL_API);
  }

  themSo(employee): Observable<any> {
    return this.http.post(this.URL_API, employee);
  }

  laySoById(id: number): Observable<any> {
    return this.http.get(`${this.URL_API}/${id}`);
  }

  editSo(so, soId): Observable<any> {
    return this.http.put(this.URL_API + '/' + soId, so);
  }
  deleteSo(soId): Observable<any> {
    return this.http.delete(this.URL_API + '/' + soId);
  }
  sort(name: string, direction: string){
    return this.http.get(this.URL_API + '?_sort=' + name + '&_order=' + direction);
  }
  searchByName(name: string) {
    return this.http.get(this.URL_API + '?id_like=' + name);
  }

  // searchByNameKhach(name: string) {
  //   return this.http.get(this.URL_API + '?khachhang.ten_like=' + name);
  // }
}
