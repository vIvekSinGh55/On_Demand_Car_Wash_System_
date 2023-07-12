import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { washerBaseURL } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor( private http : HttpClient, private router : Router) { }

  /* Register a Washer */
  registerWasher(user:any) : Observable<any>{
    return this.http.post(`${washerBaseURL}/washer/addwasher`,user, this.httpOptions);
  }
  
  /* Login a washer*/
  loginWasher(user:any) : Observable<any>{
    return this.http.post(`${washerBaseURL}/washer/auth`,user, this.httpOptions )
  }

  /* Logout a washer */
  logoutWasher(){
    localStorage.removeItem('washer');
    this.router.navigate(['/home']);
  }

  /* Check if token exists */
  loggedIn(){
    return !!localStorage.getItem('washer')
  }

  /* Fetch Token */
  getToken(){ 
    return localStorage.getItem('washer')
  }

  /* get Washer By Email */
  getWasherByEmail( email:String): Observable<any>{
    return this.http.get(`${washerBaseURL}/washer/WasherByEmail/${email}`)
  } 
}
