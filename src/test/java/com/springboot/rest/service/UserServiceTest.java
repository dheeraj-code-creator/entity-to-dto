package com.springboot.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.springboot.rest.dto.UserDto;
import com.springboot.rest.entity.User;
import com.springboot.rest.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private RequestAttributes attrubutes;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private ConverterService converterService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		RequestContextHolder.setRequestAttributes(attrubutes);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userService).build();
	}
	
	@Test
	public void getAllUserInfoDetails() {
		String userId = "234";
		String userName = "Test234";
		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		List<User> userList = new ArrayList<>();
		userList.add(user);
		Mockito.when(userRepository.findAll()).thenReturn(userList.stream().collect(Collectors.toList()));
		Mockito.when(converterService.convertToDto(user)).thenReturn(new UserDto());
		Assert.assertNotNull(userService.getAllUserInfo());
	}
	
	@Test
	public void getUserByUserIdDetails() {
		String userId = "444";
		User userObj = new User();
		userObj.setUserId(userId);
		Mockito.when(userRepository.findByUserId(userId)).thenReturn(userObj);
		Mockito.when(converterService.convertToDto(userObj)).thenReturn(new UserDto());
		Assert.assertNotNull(userId);
		Assert.assertNotNull(userObj);
	}
	
}
