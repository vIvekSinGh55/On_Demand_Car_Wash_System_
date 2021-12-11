package com.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="washers")
public class Washer 
{
	
	@Id
	private int washerId;
	private String washerName;
	private String washerEmail;
	private String washerPhone;
	private String washerAddress;
	private String washerPassword;
	
	
	public Washer() 
	{
		
	}


	public Washer(int washerId, String washerName, String washerEmail, String washerPhone, String washerAddress,
			String washerPassword) {
		super();
		this.washerId = washerId;
		this.washerName = washerName;
		this.washerEmail = washerEmail;
		this.washerPhone = washerPhone;
		this.washerAddress = washerAddress;
		this.washerPassword = washerPassword;
	}


	public int getWasherId() {
		return washerId;
	}


	public void setWasherId(int washerId) {
		this.washerId = washerId;
	}


	public String getWasherName() {
		return washerName;
	}


	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}


	public String getWasherEmail() {
		return washerEmail;
	}


	public void setWasherEmail(String washerEmail) {
		this.washerEmail = washerEmail;
	}


	public String getWasherPhone() {
		return washerPhone;
	}


	public void setWasherPhone(String washerPhone) {
		this.washerPhone = washerPhone;
	}


	public String getWasherAddress() {
		return washerAddress;
	}


	public void setWasherAddress(String washerAddress) {
		this.washerAddress = washerAddress;
	}


	public String getWasherPassword() {
		return washerPassword;
	}


	public void setWasherPassword(String washerPassword) {
		this.washerPassword = washerPassword;
	}


	@Override
	public String toString() {
		return "Washer [washerId=" + washerId + ", washerName=" + washerName + ", washerEmail=" + washerEmail
				+ ", washerPhone=" + washerPhone + ", washerAddress=" + washerAddress + ", washerPassword="
				+ washerPassword + "]";
	}
	
	
	
	
	
	
}
