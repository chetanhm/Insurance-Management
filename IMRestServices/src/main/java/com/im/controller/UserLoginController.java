package com.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.im.service.UserLoginService;

@RestController
public class UserLoginController {
	
	@Autowired
	private UserLoginService userloginService;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public @ResponseBody String registerUser(@RequestBody com.im.entity.Registration user)
	{
		userloginService.getUser(user.getUsername(),user.getPassword());	
		return registerUser(user);
	}
		
}

