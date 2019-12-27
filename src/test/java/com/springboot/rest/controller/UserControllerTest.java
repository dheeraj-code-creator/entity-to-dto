package com.springboot.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.springboot.rest.dto.UserDto;
import com.springboot.rest.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private RequestAttributes attrubutes;
	
	@Mock
	private UserService userService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		RequestContextHolder.setRequestAttributes(attrubutes);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	public void getUserinfoDetails() {
		String userId = "123";
		String userName = "Test145";
		List<UserDto> userDtoList = new ArrayList<>();
		Mockito.when(userService.getAllUserInfo()).thenReturn(userDtoList);
		Assert.assertNotNull(userController.getUserinfo());
		Assert.assertNotNull(userDtoList);
		Assert.assertNotNull(userId);
		Assert.assertNotNull(userName);
		
	}
	@Test
	public void getUserByIdDetails() {
		String userId = "123";
		UserDto userDto = new UserDto();
		Mockito.when(userService.getUserByUserId(userId)).thenReturn(userDto);
		Assert.assertNotNull(userController.getUserById(userId));
		Assert.assertNotNull(userDto);
		Assert.assertNotNull(userId);
	}

}
