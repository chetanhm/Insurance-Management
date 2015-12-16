package com.im.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public AgentDetails addUserAsAgent(Agent agent) {
		AgentDetails agentDetails=new AgentDetails(agent.getUserName(),agent.getAge(), agent.getLastQualification(),agent.getPresentOccupation(),agent.getRewards(),agent.getWorkExperience());
		
		
		if(registerRepository.findByUserName(agent.getUserName()) != null && (agent.getAge()>18))
				{agentDetails=agentRepository.insert(agentDetails);
				
			return agentDetails;
		}
		return null;

}
	public List<AgentDetails> getAllAgents() {
		// TODO Auto-generated method stub
		return agentRepository.findAll();
	}

}
