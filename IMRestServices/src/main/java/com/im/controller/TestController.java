package com.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.im.collection.UserDetails;
import com.im.service.TestService;


@CrossOrigin
@RestController
public class TestController {
	@Autowired
	private TestService registerService;
	@RequestMapping(value = "/test")
	public @ResponseBody String deleteUser() {

		registerService.TestMethod();
		return "hello";

	}

}
