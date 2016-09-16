package com.im.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.im.collection.AgentDetails;
import com.im.entity.Agent;
import com.im.repository.AgentRepository;
import com.im.repository.RegisterRepository;

import ch.qos.logback.core.net.SyslogOutputStream;
@Service
public class AgentDetailsImplementation implements AgentDetailsService{	
	
	@Autowired
	private RegisterRepository registerRepository;
	@Autowired
	private AgentRepository agentRepository;
	ObjectMapper mapper = new ObjectMapper();
	
	public String addUserAsAgent(Agent agent) throws JsonProcessingException {
		AgentDetails agentDetails=new AgentDetails(agent.getUserName(),agent.getAge(), agent.getLastQualification(),agent.getPresentOccupation(),agent.getRewards(),agent.getWorkExperience(),"pending", agent.getPhone(), agent.getEmail());
		
		if(registerRepository.findByUserName(agent.getUserName()) == null) {
			return "{ \"Error\": \"UserName does not exist\"}";
		}
		else if(agent.getAge()<18) {
			return "{ \"Error\": \"Age should be above 18\"}";
		}
		else {
			agentDetails=agentRepository.insert(agentDetails);
			return mapper.writeValueAsString(agentDetails);
		}

}
	public List<AgentDetails> getAllAgents() {
		// TODO Auto-generated method stub
		return agentRepository.findAll();
	}
	
	public List<AgentDetails> getAgentsByStatus(String status) {
		return agentRepository.getAgentsByStatus("pending");
	}
	
	public AgentDetails setAgentType(String userName, String userType) {
		// TODO Auto-generated method stub
		AgentDetails updateAgentDetails = agentRepository.findByUserName(userName);
		updateAgentDetails.setUserType(userType);
		agentRepository.save(updateAgentDetails);
		return updateAgentDetails;
	}
	public AgentDetails getAgent(String userName) {
		
		return agentRepository.findByUserName(userName);
	}

}
