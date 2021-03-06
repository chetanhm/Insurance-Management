package com.im.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.im.collection.AgentDetails;

public interface AgentRepository extends MongoRepository<AgentDetails,String>{

	@Query(value="{userName: ?0}")
	public AgentDetails findByUserName(String userName);
	@Query(value="{userType: ?0}")
	public List<AgentDetails> getAgentsByStatus(String status);
}
