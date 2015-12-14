package com.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.im.collection.AgentDetails;
import com.im.entity.Agent;
import com.im.service.AgentDetailsService;

@CrossOrigin
@RestController
@RequestMapping(value = "/imservices")
public class AgentController {

	@Autowired
	private AgentDetailsService agentService;

	@RequestMapping(value = "/agent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AgentDetails apply(@RequestBody Agent agent) {
		return agentService.addUserAsAgent(agent);				 
		
	}
}
