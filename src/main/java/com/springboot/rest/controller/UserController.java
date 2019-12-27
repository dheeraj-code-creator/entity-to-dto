package com.springboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.dto.UserDto;
import com.springboot.rest.entity.User;
import com.springboot.rest.service.UserService;


@RestController
@RequestMapping(value = "/userinfo")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// get all userinfo
	@GetMapping(value = "/alluser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> getUserinfo() {
		return userService.getAllUserInfo();
	}
	
	
	  //get user info by id
	  
	  @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	  public UserDto getUserById(@PathVariable("userId") String userId) { 
		  return userService.getUserByUserId(userId); }
	 
}
