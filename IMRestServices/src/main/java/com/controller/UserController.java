package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Registration;
import com.service.RegisterService;
import com.user.UserRegisterPojo;

@RestController
public class UserController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping("/hello")
	public String sayHello(@RequestParam(value="name", defaultValue="Ivan") String name) {
		return "Hello " + name;
	}
	
	@RequestMapping(value="/imregister" , method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE , consumes= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Registration registerUser(@RequestBody Registration registration)
	{
	
		registerService.save(
				new UserRegisterPojo(registration.getFirstName(), 
						registration.getLastName(), 
						registration.getAddress(), 
						registration.getState(), 
						registration.getCity(), 
						registration.getContact_no(), 
						registration.getEmail(), 
						registration.getUsername(), 
						registration.getPassword()));
		return registration;
	}

}
