package com.im.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.im.collection.UserDetails;

public interface TestRepository extends MongoRepository<UserDetails, String> {

	@Query(value="{username: ?0}")
	public UserDetails findByUserName(String username);
}
