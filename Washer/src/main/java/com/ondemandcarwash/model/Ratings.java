package com.ondemandcarwash.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Ratings")
public class Ratings 
{
	@Id
	private int rating;
	private String washerName;
	private String comment;
	
	
	public Ratings() 
	{
		
	}
	
	public Ratings(int rating, String washerName, String comment) 
	{
		super();
		this.rating = rating;
		this.washerName = washerName;
		this.comment = comment;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getWasherName() {
		return washerName;
	}


	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Ratings [rating=" + rating + ", washerName=" + washerName + ", comment=" + comment + "]";
	}
	
	
	
}
