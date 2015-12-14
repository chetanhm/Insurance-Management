package com.im.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.im.collection.PolicyDetails;


public interface PolicyRepository extends MongoRepository<PolicyDetails, String> {
	
	@Query(value="{userName: ?0}")
	public List<PolicyDetails> findByUserName(String name);

}
