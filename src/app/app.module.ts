import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Components/header/header.component';
import { FooterComponent } from './Components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PlansService } from './Services/plans/plans.service';
import { AuthServiceService } from './Services/Customer/auth/auth-service.service';
import { AuthService } from './Services/Washer/auth/auth.service';
import { AdminAuthService } from './Services/Admin/auth/admin-auth.service';
import { PlanManagementService } from './Services/Admin/planManagement/plan-management.service';
import { ManagecustomerService } from './Services/Admin/manageCustomer/managecustomer.service';
import { ManagewasherService } from './Services/Admin/manageWasher/managewasher.service';
import { OrderService } from './Services/Customer/order/order.service';
import { ManageOrderService } from './Services/Admin/manageOrder/manage-order.service';
import { MyOrderService } from './Services/Washer/order/my-order.service';
import { RatingService } from './Services/Customer/review/rating.service';
import { MyratingService } from './Services/Admin/review/myrating.service';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    routingComponents,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [PlansService,
              AuthServiceService,
              OrderService,
              RatingService,
              AdminAuthService,
              PlanManagementService,
              ManagecustomerService,
              ManagewasherService,
              ManageOrderService,
              MyratingService,
              AuthService,
              MyOrderService],
              
  bootstrap: [AppComponent]
})
export class AppModule { }
