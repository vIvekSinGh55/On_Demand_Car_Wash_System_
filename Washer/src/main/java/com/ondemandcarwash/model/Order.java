package com.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orders")
public class Order 
{
	@Id
	private int orderId;
	private String carName;
	private String carModel;
	private String wName;
	private String date;
	private long phoneNo;
	
	public Order()
	{
		
	}

	public Order(int orderId, String carName, String carModel, String wName, String date, long phoneNo) {
		super();
		this.orderId = orderId;
		this.carName = carName;
		this.carModel = carModel;
		this.wName = wName;
		this.date = date;
		this.phoneNo = phoneNo;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", carName=" + carName + ", carModel=" + carModel + ", wName=" + wName
				+ ", date=" + date + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
	
}
