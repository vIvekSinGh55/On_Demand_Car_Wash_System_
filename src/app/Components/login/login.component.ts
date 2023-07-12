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
  passwordError ='';
  msg = 'Have Successfully Logged in!';
  oPassword = '';

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
      this.searchCustomerByEmail(user.email);
      this._auth.loginCustomer(user)
      .subscribe(
        res => {
          localStorage.setItem('customer',res)
          console.log(this.details[0].password)
          if(user.password == this.oPassword){
            console.log(user)
          this.router.navigate(['/customerDashboard/customerHome'])
          alert(customer.value.email +' Have Successfully Logged in!');
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
      this.searchWasherByEmail(user.email);
      this._washerAuth.loginWasher(user)
      .subscribe(
        res => {
          localStorage.setItem('washer',res)
          console.log(this.details[0].password)
          if(user.password == this.oPassword){
            console.log(user)
            this.router.navigate(['/washerDashboard/washerHome'])
            alert(user.email +' Have Successfully Logged in!');
          }
          else{
            alert("Bad Credential")
          }
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
   
    searchCustomerByEmail(email:string): void {
  
      this._planService.getCustomerByEmail(email)
        .subscribe({
          next: (data) => {
            this.oPassword = data.password;
          },
          error: (e) => console.error(e)
        });
    }


    searchWasherByEmail(email:string): void {

      this._washerAuth.getWasherByEmail(email)
        .subscribe({
          next: (data) => {
            this.oPassword = data.password;
          },
          error: (e) => console.error(e)
        });
    }


}