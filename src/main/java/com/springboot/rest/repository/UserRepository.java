package com.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.entity.User;


public interface UserRepository extends JpaRepository<User, String>{
	public User findByUserId(String userId);

}
