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
import com.im.service.UserDetailsService;

@CrossOrigin
@RestController
@RequestMapping(value = "/imservices")
public class UserController {

	@Autowired
	private UserDetailsService registerService;

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDetails registerUser(
			@RequestBody Registration registration) {

		UserDetails users = registerService.insertUser(new UserDetails(
				registration.getFirstName(), registration.getLastName(),
				registration.getAddress(), registration.getState(),
				registration.getCity(), registration.getContactNo(),
				registration.getEmail(), registration.getUserName(),
				registration.getPassword()));
		return users;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDetails logout(@RequestParam(name = "id") String id) {

		return registerService.logoutUser(id);

	}
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDetails loginUser(
			@RequestParam(name = "userName") String userName,
			@RequestParam(name = "password") String password) {
		UserDetails userDetails = registerService.loginUser(userName, password);
		return userDetails;

	}

	
	@RequestMapping(value = "/user/check", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String isUserExists(
			@RequestParam(name = "userName") String username,
			@RequestParam(name = "email") String email) {
		UserDetails userDetails = registerService.getUserByEmail(email);
		if (userDetails == null) {
			userDetails = registerService.getUserByUsername(username);
			if (userDetails == null) {
				return "{\"status\": \"ok\"}";
			} else {
				return "{\"status\": \"userName-fail\"}";
			}
		} else {
			return "{\"status\": \"email-fail\"}";
		}
	}
	
	@RequestMapping(value="/user", method = RequestMethod.PUT)
	public UserDetails updateUserType(@RequestParam(name="userName") String userName, @RequestParam(name="userType") String userType)
	{
		return registerService.setAgentStatus(userName,userType);		
	}
}
