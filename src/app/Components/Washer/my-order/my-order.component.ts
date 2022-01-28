import { Component, OnInit } from '@angular/core';
import { MyOrderService } from 'src/app/Services/Washer/order/my-order.service';

@Component({
  selector: 'app-my-order',
  templateUrl: './my-order.component.html',
  styleUrls: ['./my-order.component.css']
})
export class MyOrderComponent implements OnInit {

  orderDetails=[] as any;
  constructor(private _orderDetails: MyOrderService) { }

  ngOnInit(): void {
    this.orderDetails =[] ;
    this._orderDetails.getAllOrder()
    .subscribe(
      res => this.orderDetails=res,
      err => console.log(err)
    )
  }

}
