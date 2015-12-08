package com.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.im.service.UserDetailsService;


@RestController
public class UserLoginController {
	
	@Autowired
	private UserDetailsService userloginService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public @ResponseBody String registerUser(@RequestBody com.im.entity.Registration user)
	{
		userloginService.getUser(user.getUsername(),user.getPassword());	
		return registerUser(user);
	}
		
}

