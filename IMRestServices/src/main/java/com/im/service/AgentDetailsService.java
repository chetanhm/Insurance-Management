package com.im.service;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.im.collection.AgentDetails;
import com.im.entity.Agent;

public interface AgentDetailsService {
	public String addUserAsAgent(Agent agent) throws JsonProcessingException;
	public List<AgentDetails> getAllAgents();
	public List<AgentDetails> getAgentsByStatus(String status);
	public AgentDetails setAgentType(String userName, String userType);
	public AgentDetails getAgent(String userName);
}
