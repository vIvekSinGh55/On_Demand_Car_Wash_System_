package com.ondemandcarwash.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ondemandcarwash.model.Order;
import com.ondemandcarwash.model.Ratings;
import com.ondemandcarwash.model.Washer;
import com.ondemandcarwash.model.WasherAuthResponse;
import com.ondemandcarwash.repository.WasherRepository;
import com.ondemandcarwash.service.WasherService;

@RestController
@RequestMapping("/washer")
@CrossOrigin(origins = "http://localhost:4200")
public class WasherController 
{
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WasherService washerService;
	
	@Autowired
	private WasherRepository washerRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/msg")
	public String message() {
		return "Hello! Welcome form Washer page";
	}
	
	
	//authenticating washer
	@PostMapping("/auth")
	private ResponseEntity<?> authWasher(@RequestBody Washer washer){
		String email = washer.getEmail();
		String password = washer.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
				
		} catch (Exception e){
				
			return ResponseEntity.ok(new WasherAuthResponse("Error during  washer Authentication"+ email));
		}
		return ResponseEntity.ok(new WasherAuthResponse("Successfully Authenticated washer"+ email));
			
	}
	
	

	//Creating/Adding Washer
	@PostMapping("/addwasher")
	public Washer saveWasher(@RequestBody Washer washer) 
	{
		return washerService.addWasher(washer);
	}
	
	
	
	//Reading all washer
	@GetMapping("/allwashers")
	public List<Washer> findAllWashers()
	{
		return washerService.getWashers();
	}

	
	//Reading Washer by ID
	@GetMapping("/allwashers/{id}")
	public Optional<Washer> getWasherById(@PathVariable int id)
	{
		return washerRepository.findById(id);
				
	}
	
	
	//Updating Washer Data by Id
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateWasher(@PathVariable int id, @RequestBody Washer washer)
	{
		
			washerRepository.save(washer);
			return new ResponseEntity<Object>("Washer updated successfully with id " +id, HttpStatus.OK);
		
				
	}
	
	
	// Deleting Washer Data by Id 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteWasher(@PathVariable int id)
	{
		washerService.deleteById(id);
		return new ResponseEntity<Object>("Washer deleted with id"+id,HttpStatus.OK);
	}
	
	
//-------------------------------------------Order--------------------------------------------------//
	
	//Reading all orders 
	@GetMapping("/allorders")
	public List<Order> getallorders()
	{
		String baseurl="http://localhost:8084/order/allorders";
		Order[] allorders=restTemplate.getForObject(baseurl, Order[].class);
		
		return Arrays.asList(allorders);
	}

	//Reading orders By Id 
	@GetMapping("/orders/{id}")
	public Order getOrderById(@PathVariable("id") int id) 
	{
		return restTemplate.getForObject("http://localhost:8084/order/orders/" + id, Order.class);
	}
	
	
	//------------------------------------Ratings----------------------------------------------------//
	
	//Reading all ratings from washer 
	@GetMapping("/allratings")
	public List<Ratings> getallratings()
	{
		String baseurl="http://localhost:8083/admin/allratings";
		Ratings[] allratings=restTemplate.getForObject(baseurl, Ratings[].class);
		
		return Arrays.asList(allratings);
	}
	
	
	
	
}
