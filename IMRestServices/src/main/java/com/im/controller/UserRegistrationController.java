package com.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.im.collection.UserDetails;
import com.im.entity.Registration;
import com.im.service.RegisterService;

@CrossOrigin
@RestController
public class UserRegistrationController {

	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value = "/imregister", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Registration registerUser(@RequestBody Registration registration) {

		registerService.save(
				new UserDetails(registration.getFirstName(), registration.getLastName(), registration.getAddress(),
						registration.getState(), registration.getCity(), registration.getContact_no(),
						registration.getEmail(), registration.getUsername(), registration.getPassword()));
		return registration;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDetails deleteUser(@RequestBody UserDetails registration) {

		registerService.delete(registration.getUsername());
		return registration;

	}

}
