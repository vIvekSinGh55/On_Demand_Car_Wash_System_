import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { customerBaseURL } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
    
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http : HttpClient, private router : Router) { }

  /* Register a customer */
  registerCustomer(user: any): Observable<any>{
    return this.http.post(`${customerBaseURL}/customer/addcustomer`,user, this.httpOptions );
  }
  
  /* Login a customer */
  loginCustomer(user: any) : Observable<any>{
    return this.http.post(`${customerBaseURL}/customer/auth`,user, this.httpOptions )
  }

  /* Logout a customer */
  logoutCustomer(){
    localStorage.removeItem('customer');
    this.router.navigate(['/home']);
  }

  /* Check if token exists */
  loggedIn(){
    return !!localStorage.getItem('customer')
  }

  /* Fetch Token */
  getToken(){ 
    return localStorage.getItem('password')
  }

  /* Login with google */
  googleLogin() : Observable<any>{
    return this.http.get(`${customerBaseURL}/google`);
  }
}
