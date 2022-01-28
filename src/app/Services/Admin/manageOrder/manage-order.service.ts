import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { adminBaseURL } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ManageOrderService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  /* Get all Order */
  getAllOrder(): Observable<any> {
    return this.http.get(`${adminBaseURL}/admin/allorders`);
  }

  /* Delete a Order */
  deleteOrder(id:number) : Observable <any> {
    return this.http.delete(`${adminBaseURL}/admin/removeorder/${id}`)
  }
}
