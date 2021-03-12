import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class KhachhangService {

  private URL_API = 'http://localhost:3000/khachhang';

  constructor(
    public http: HttpClient
  ) { }

  layKhachHangs(): Observable<any>{
    return this.http.get(this.URL_API);
  }

  themKhachHang(khachHang): Observable<any> {
    return this.http.post(this.URL_API, khachHang);
  }

  // laySoById(id: number): Observable<any> {
  //   return this.http.get(`${this.URL_API}/${id}`);
  // }

  editKhachHang(so, soId): Observable<any> {
    return this.http.put(this.URL_API + '/' + soId, so);
  }
  deleteKhachHang(khachId): Observable<any> {
    return this.http.delete(this.URL_API + '/' + khachId);
  }
}
