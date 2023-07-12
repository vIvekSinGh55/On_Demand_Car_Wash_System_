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
  oPassword = '';

  constructor(private router: Router,  private _adminAuth: AdminAuthService) { }

  ngOnInit(): void {
  }

  /* Admin Login  */

  login(data:any){
    this.emailError='',
    this.passwordError='';
    console.log(data.value);
    this.searchAdminByEmail(data.value.aEmail)
    this._adminAuth.loginAdmin(data.value)
    .subscribe(
      res => {
        localStorage.setItem('admin',res.admin)
        if(data.value.aPassword == this.oPassword){
          console.log(data.value)
          this.router.navigate(['/adminDashboard/adminHome'])
          alert(data.value.aEmail +' Have Successfully Logged in!');
        }
        else{
          alert("Bad Credential")
        }
      },
      err => {
        this.emailError = err.error.email,
        this.passwordError = err.error.password
      }
    )  
  }

  searchAdminByEmail(aEmail:string): void {

    this._adminAuth.getAdminByaEmail(aEmail)
      .subscribe({
        next: (data) => {
          this.oPassword = data.aPassword;
        },
        error: (e) => console.error(e)
      });
  }


}
