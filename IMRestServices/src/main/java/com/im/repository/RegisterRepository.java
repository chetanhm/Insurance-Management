package com.im.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.im.collection.UserDetails;

public interface RegisterRepository extends MongoRepository<UserDetails, String> {

	@Query(value="{userName: ?0}")
	public UserDetails findByUserName(String username);
	
	@Query(value="{email: ?0}")
	public UserDetails findByEmail(String email);
	
	@Query(value="{agentUserName: ?0}")
	public List<UserDetails> findByAgentUserName(String agentUserName);
}
