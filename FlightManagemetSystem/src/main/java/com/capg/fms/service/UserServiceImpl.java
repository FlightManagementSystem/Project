package com.capg.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.fms.entity.User;
import com.capg.fms.exception.UserNotFoundException;
import com.capg.fms.repository.UserRepository;


@Service
@Transactional
public  class UserServiceImpl implements IUserService {
	
	List<User> users=new ArrayList<>();
	@Autowired
	 private UserRepository userRepository;

	@Override
	public User addUser( User user) {
		
		 userRepository.save(user);
		 return user;
	}
	@Override
	public List<User> viewUser() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User viewUserById(int Id) {
		
     return userRepository.findById(Id);
	}

	

	@Override
	public void deleteUserById(int userId) {
		userRepository.deleteById(userId);
		
	}
	@Override
	public User updateById(@RequestBody User user) {
	return userRepository.save(user);
//		User customerToUpdate = userRepository.getOne(userId);
//		customerToUpdate.setUserAge(user.getUserAge());
//		customerToUpdate.setUserName(user.getUserName());
//		customerToUpdate.setUserPassword(user.getUserPassword());
//		customerToUpdate.setUserPhone(user.getUserPhone());
//		customerToUpdate.setUserEmail(user.getUserEmail());
//		
//		 return userRepository.save(customerToUpdate);
		
	}
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}      		
}