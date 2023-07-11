package com.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="admins")
public class Admin 
{
	@Id
	private String aId;
	private String adminName;
	private String aEmail;
	private String aPassword;
	
	public Admin() 
	{
		
	}

	public Admin(String aId, String adminName, String aEmail, String aPassword) {
		super();
		this.aId = aId;
		this.adminName = adminName;
		this.aEmail = aEmail;
		this.aPassword = aPassword;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", adminName=" + adminName + ", aEmail=" + aEmail + ", aPassword=" + aPassword
				+ "]";
	}
	
	
	
	
	
}
