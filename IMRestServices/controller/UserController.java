package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Registration;
import com.spring.mongo.collections.UserRegistration;
import com.spring.service.RegistrationService;

@RestController
public class UserController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping("/hello")
	public String sayHello(@RequestParam(value="name", defaultValue="Rea") String name) {
		return name+" Logged out ";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Registration registerUser(@RequestBody Registration registration) {
		registrationService.save(new UserRegistration(registration.getUserName(), registration.getFirstName(), registration.getPassword()));
		return registration;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Registration deleteUser(@RequestBody Registration registration) {
		System.out.println("-->"+registration.getUserName());
		registrationService.delete(registration.getUserName());
		return registration;
		
	}
	

	
}
