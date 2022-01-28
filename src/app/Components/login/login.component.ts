import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/Services/Customer/auth/auth-service.service';
import { ProfileService } from 'src/app/Services/Customer/profile/profile.service';
import { AuthService } from 'src/app/Services/Washer/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  selected="Customer";
  emailError ='';
  dbpassword ='vivek12';
  passwordError ='';
  msg =' Have Successfully Logged in!';

  details=[] as any;

  constructor(private router : Router,private _planService : ProfileService, private _auth : AuthServiceService, private _washerAuth: AuthService) { }

  ngOnInit(): void {
    this.details =[];
    this._planService.getCustomer()
      .subscribe(
        res => this.details.push(res),
        err => console.log(err)
      )
  }

  /* Show and hide password */
  showpass(x:any,text:any){
    if (x.type === "password") {
      x.type = "text";
      text.text = "Hide"
    } else {
      text.text ="Show";
      x.type = "password";
    }
 }

  /* Login the user */
  login(customer:any){

    this.emailError =''; 
    this.passwordError='';

    if(customer.value.role == 'Customer'){
      let user = { email: customer.value.email, password : customer.value.password};
      this._auth.loginCustomer(user)
      .subscribe(
        res => {
          localStorage.setItem('customer',res)
          console.log(this.details[0].password)
          if(customer.value.password == this.dbpassword){
            console.log(user)
          this.router.navigate(['/customerDashboard/customerHome'])
          alert((this.msg));
          }
          else{
            alert("Bad Credential")
          }
        },
        err => {this.emailError = err.error.email, this.passwordError = err.error.password
          console.log(err)
        alert("Invalid!")}
      )
    }

    if(customer.value.role == 'Washer'){
      let user = { email: customer.value.email, password : customer.value.password};
      this._washerAuth.loginWasher(user)
      .subscribe(
        res => {
          localStorage.setItem('washer',res)
          this.router.navigate(['/washerDashboard/washerHome'])
          alert(this.msg );
        },
        err => {this.emailError =err.error.email, this.passwordError = err.error.password
          alert("Invalid!")}
      )
    }
  } 
  /* Login with Google */
   googleLogin(){
    this._auth.googleLogin()
      .subscribe(
        res=>console.log(res),
       err => console.log(err)
      )
    }



}