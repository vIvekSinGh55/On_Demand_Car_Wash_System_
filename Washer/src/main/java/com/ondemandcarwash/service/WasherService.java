package com.ondemandcarwash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ondemandcarwash.model.Washer;
import com.ondemandcarwash.repository.WasherRepository;

@Service
public class WasherService implements UserDetailsService
{
	@Autowired
	private WasherRepository washerRepository;
	
  /*  
	//for creating/adding washer
	public Washer addWasher(Washer washer)
	{
		return washerRepository.save(washer);
	}
  */
	
	////For getting All Washer
	public List<Washer> getWashers() 
	{
		// TODO Auto-generated method stub
		List<Washer> washer= washerRepository.findAll();
		System.out.println("Getting Washer from DB" + washer);
		return washer;
	}

	//For deleting By Id
	public void deleteById(int id)
	{
		washerRepository.deleteById(id);
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Washer foundedWasher = washerRepository.findBywasherEmail(username);
		
		if  (foundedWasher ==null) return null;
		String washerEmail = foundedWasher.getWasherEmail();
		String washerPassword = foundedWasher.getWasherPassword();
		return new User(washerEmail, washerPassword, new ArrayList<>());
	}
}
