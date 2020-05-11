package com.capg.fms.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.controller.UserController;
import com.capg.fms.entity.User;
import com.capg.fms.exception.UserNotFoundException;
import com.capg.fms.service.IUserService;



@RestController
@RequestMapping("/Users")
public class UserController {
	private static final Logger log =LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	 private IUserService IUserService;

	
	//Add User
	@PostMapping("/addUser")
	public User index( @RequestBody User user)
	{
		
		
		return IUserService.addUser(user);
	}
	
	@GetMapping("/viewAllUsers")
	public List<User> viewUsers(){
		return IUserService.viewUser();	

	}
	
	//View User
	@GetMapping("/viewUserById/{userId}")
	public User viewUser(@PathVariable int userId)
	{
		return IUserService.viewUserById(userId);	
				}
	


	// Delete User
	@DeleteMapping("/deleteUser/{userId}")
	 public boolean delete(@PathVariable int userId) {
	     IUserService.deleteUserById(userId);
               return true;                                                                                                                          
	  }
	
	// Update User
	@PutMapping(value="/user/modify",consumes= {"application/json"})
	public User modifyFlight(@RequestBody User user) {
		return IUserService.updateUser(user);
	}
	}


