package com.userlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.userlogin.entity.User;
import com.userlogin.service.UserloginService;




@RestController
public class UserloginController {
	
	@Autowired
	private UserloginService userloginService;
	
	@RequestMapping("/hello")
	public String sayHello(@RequestParam(value="name", defaultValue="Ivan") String name) {
		return "Hello " + name;
	}

	@RequestMapping(value="/login", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	
		
	public @ResponseBody javax.servlet.Registration registerUser(@RequestBody User user)
	{
		userloginService.getUser(user.getUserName());
	
		return registerUser(user);
	}
		
}

