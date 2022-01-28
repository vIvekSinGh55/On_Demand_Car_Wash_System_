import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminAuthService } from 'src/app/Services/Admin/auth/admin-auth.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  emailError ='';
  passwordError ='';

  constructor(private router: Router,  private _adminAuth: AdminAuthService) { }

  ngOnInit(): void {
  }

  /* Admin Login  */

  login(data:any){
    this.emailError='',
    this.passwordError='';
    console.log(data.value);

    this._adminAuth.loginAdmin(data.value)
    .subscribe(
      res => {
        localStorage.setItem('admin',res.admin)
        this.router.navigate(['/adminDashboard/adminHome'])
      },
      err => {
        this.emailError = err.error.email,
        this.passwordError = err.error.password
      }
    )  
  }
}
