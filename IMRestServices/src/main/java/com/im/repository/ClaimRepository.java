/**
 * 
 */
package com.im.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.im.collection.ClaimDetails;

/**
 * @author khatwani_s
 *
 */
public interface ClaimRepository extends MongoRepository<ClaimDetails, String> {
	@Query(value="{userName: ?0}")
	public List<ClaimDetails> findByUserName(String userName);
}
