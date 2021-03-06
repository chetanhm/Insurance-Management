package com.im.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
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
	public String apply(@RequestBody Agent agent) throws JsonProcessingException {
		
		return agentService.addUserAsAgent(agent);				 
		
	}

	@RequestMapping(value = "/agent/{agentUserName}/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserDetails registerManagedCustomer(
			@RequestBody Registration managedCustomer, @PathVariable(value="agentUserName") String agentUserName ) {
		UserDetails users = registerService.registerManagedCustomer(managedCustomer,agentUserName);
		return users;
	}
	

	@RequestMapping(value="/agent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AgentDetails> getAllAgents()
	{
		return agentService.getAllAgents();		
	}
	
	@RequestMapping(value="/agent/pending", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AgentDetails> getPendingAgents()
	{
		return agentService.getAgentsByStatus("pending");		
	}

	@RequestMapping(value="/agent/{agentUserName}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AgentDetails getAgentByName(@PathVariable(value="agentUserName") String agentUserName){
		return agentService.getAgent(agentUserName);
	}
	
	@RequestMapping(value="/agent/{agentUserName}/user", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserDetails> getUserByAgentName(@PathVariable(value="agentUserName") String agentUserName){
		return registerService.getUserByAgentName(agentUserName);
	}
	
	@RequestMapping(value="/agent", method = RequestMethod.PUT)
	public AgentDetails updateAgentType(@RequestParam(name="userName") String userName, @RequestParam(name="userType") String userType)
	{
		return agentService.setAgentType(userName, userType);
	}
	
}
