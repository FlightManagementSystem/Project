package com.capg.fms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.fms.entity.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	User save(User user);

	List<User> findAll();

	User findById(int id);

	void deleteById(int userId);

	

	


	
	
	

	

	

}