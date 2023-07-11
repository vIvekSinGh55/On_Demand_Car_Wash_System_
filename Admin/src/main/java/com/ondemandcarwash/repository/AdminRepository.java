package com.ondemandcarwash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ondemandcarwash.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
	
	Admin findByaEmail(String aEmail);

}
