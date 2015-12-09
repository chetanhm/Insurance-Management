package com.im.controller;

import javax.servlet.http.HttpSession;

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
@RequestMapping(value="/imservices")
public class UserController {

	@Autowired
	private UserDetailsService registerService;

	@RequestMapping(value = "/imregister", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDetails registerUser(@RequestBody Registration registration) {

		UserDetails users= registerService.insertUser(
				new UserDetails(registration.getFirstName(), registration.getLastName(), registration.getAddress(),
						registration.getState(), registration.getCity(), registration.getContact_no(),
						registration.getEmail(), registration.getUserName(), registration.getPassword()));
		return users;
	}

	@RequestMapping(value = "/logout", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "{status: ok}";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDetails loginUser(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, HttpSession httpSession) {
		UserDetails userDetails = registerService.loginUser(username,password);
		return userDetails;
	}
	
	@RequestMapping(value="/usernameAvailable", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String usernameAvailable(@RequestParam(name="username") String username,@RequestParam(name="email") String email)
	{
		UserDetails userDetails = registerService.getUserByEmail(email);
		if(userDetails==null)
		{
			userDetails=registerService.getUserByUsername(username);
			if(userDetails==null)
			{
				return "{\"status\": \"ok\"}";
			}
			else
			{
				return "{\"status\": \"username-fail\"}";
			}
			
		}
		else
		{
			return "{\"status\": \"email-fail\"}";
		}
	}

}
