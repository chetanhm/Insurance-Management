package com.im.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.im.collection.Policies;


public interface PolicyRepository extends MongoRepository<Policies, String> {
	
	@Query(value="{userName: ?0}")
	public List<Policies> findByUserName(String name);

}
