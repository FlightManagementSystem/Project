package com.capg.fms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.fms.entity.User;

@Service
public interface IUserService {
	
	
	
	public User addUser(User user);
	public List<User> viewUser();
	public User viewUserById(int Id);
	public void deleteUserById(int userId);
	public User updateById(@RequestBody User user);
	public User updateUser(User user);
	
  
	
	
	
	
	
	
	
	
	
}


	