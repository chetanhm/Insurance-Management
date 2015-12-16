package com.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.im.collection.AgentDetails;
import com.im.collection.UserDetails;
import com.im.entity.Agent;
import com.im.entity.Registration;
import com.im.service.AgentDetailsService;
import com.im.service.UserDetailsService;

@CrossOrigin
@RestController
@RequestMapping(value = "/imservices")
public class AgentController {

	@Autowired
	private AgentDetailsService agentService;

	@Autowired
	private UserDetailsService registerService;

	@RequestMapping(value = "/agent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AgentDetails apply(@RequestBody Agent agent) {
		
		return agentService.addUserAsAgent(agent);				 
		
	}

	@RequestMapping(value = "/agent/{agentUserName}/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDetails registerManagedCustomer(
			@RequestBody Registration managedCustomer, @PathVariable(value="agentUserName") String agentUserName ) {
		UserDetails users = registerService.registerManagedCustomer(managedCustomer,agentUserName);
		
	
		
		return users;
	}
}
