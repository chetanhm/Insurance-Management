package com.im.service;
import java.util.List;

import com.im.collection.AgentDetails;
import com.im.entity.Agent;

public interface AgentDetailsService {
	public AgentDetails addUserAsAgent(Agent agent);
	public List<AgentDetails> getAllAgents();
	public AgentDetails setAgentType(String userName, String userType);
}
