package com.example.firstrunningapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	@Autowired
	UserDaoService uservice;
	
	
	@GetMapping("/users") 

	public List<User> retrieveAllUsers() {
		return uservice.findAll();
	}

	 

	@GetMapping("/users/{id}") 

	public User retrieveUser(@PathVariable int id) {
		return uservice.findOne(id);
		
	}

	 
}
