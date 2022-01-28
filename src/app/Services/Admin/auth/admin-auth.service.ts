import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { adminBaseURL } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http : HttpClient, private router: Router) { }

  /* Admin login */
  loginAdmin(data:any): Observable <any> {
    return this.http.post(`${adminBaseURL}/admin/auth`,data, this.httpOptions);
  }

  /* Logout the admin */
  logoutAdmin(){
    localStorage.removeItem('admin');
    this.router.navigate(['/home']);
  }

  /* Check if token exists */
  loggedIn(){
    return !!localStorage.getItem('admin')
  }

  /* Fetch Token */
  getToken(){ 
    return localStorage.getItem('admin')
  }
}
