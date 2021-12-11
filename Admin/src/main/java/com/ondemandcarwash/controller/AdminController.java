package com.ondemandcarwash.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ondemandcarwash.model.Admin;
import com.ondemandcarwash.model.Ratings;
import com.ondemandcarwash.model.WashPack;
import com.ondemandcarwash.repository.AdminRepository;
import com.ondemandcarwash.repository.RatingRepository;
import com.ondemandcarwash.repository.WashPackRepository;
import com.ondemandcarwash.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController 
{	
	@Autowired
	private AdminRepository adminRepository;
	
	
	@Autowired
	private AdminService adminService;
	
	
	@Autowired
	private WashPackRepository washPackRepository;
	
	
	@Autowired
	private RatingRepository ratingRepository;
	
	
	
	@GetMapping("/msg")
	public String message() {
		return "Hello! WELCOME from Admin Side";
	}
	
	//Creating/ADDING Admin
	@PostMapping("/addadmin")
	public Admin saveAdmin(@RequestBody Admin admin) 
	{
		return adminService.addAdmin(admin);
			
	}
	

	//Reading all Admin 
	@GetMapping("/alladmins")
	public List<Admin> findAllAdmins()
	{
		return adminService.getAdmins();
			
	}
	
	//Reading Admin by ID
	@GetMapping("/alladmins/{id}")
	public Optional<Admin> getAdminById(@PathVariable int id)
	{
		return adminRepository.findById(id);
	}
	
	
	//Updating Admin Data by Id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateAdmin(@PathVariable int id, @RequestBody Admin admin)
	{
		
		adminRepository.save(admin);
		return new ResponseEntity<Object>("Admininfo updated successfully with id " +id, HttpStatus.OK);
		
			
	}
	
	// Deleting Admin Data by Id 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteAdmin (@PathVariable int id)
	{	
		adminService.deleteById(id);
		return new ResponseEntity<Object>("Admininfo deleted with id"+id,HttpStatus.OK);		
	}
	
	
	//Creating and adding washpack
	@PostMapping("/addpack")
	public String savepack(@RequestBody WashPack washpack)
	{
		washPackRepository.save(washpack);
		return " Pack saved successfully with id :"+washpack.getId();
	}
	
	
	//Reading all washpack
	@GetMapping("/allpacks")
	public List<WashPack> getallpack()
	{
		return washPackRepository.findAll();
	}
	
	//Deleting washpack by id
	@DeleteMapping("/deletepack/{id}")
	public String deletepack(@PathVariable int id)
	{
		washPackRepository.deleteById(id);
		return "pack deleted with id "+id;
	}
	
	//Creating and adding ratings
	@PostMapping("/addrating")
	public String saverating(@RequestBody Ratings rating)
	{
		ratingRepository.save(rating);
		return " Thanks for Your Valuable feedback";
	}
	
	//Reading all ratings
	@GetMapping("/allratings")
	public List<Ratings> getallrating()
	{
		return ratingRepository.findAll();
	}
}

