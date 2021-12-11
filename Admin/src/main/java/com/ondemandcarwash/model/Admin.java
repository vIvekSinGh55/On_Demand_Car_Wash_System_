package com.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="admins")
public class Admin 
{
	@Id
	private int aId;
	private String adminName;
	
	public Admin() 
	{
		
	}
	
	
	public Admin(int aId, String adminName) {
		super();
		this.aId = aId;
		this.adminName = adminName;
	}


	public int getaId() {
		return aId;
	}


	public void setaId(int aId) {
		this.aId = aId;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", adminName=" + adminName + "]";
	}
	
	
	
}
