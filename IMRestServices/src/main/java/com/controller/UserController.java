package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Registration;
import com.mongo.UserRegisterPojo;
import com.service.RegisterService;
import com.userlogin.entity.User;

@CrossOrigin
@RestController
public class UserController {
	//opopop
	@Autowired
	private RegisterService registerService;
	@Autowired 
	private RegisterService registrationService;
	
	
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
	@RequestMapping(value="/delete", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User deleteUser(@RequestBody User registration) {
		System.out.println("-->"+registration.getUserName());
		registrationService.delete(registration.getUserName());
		return registration;
		
	}

}
