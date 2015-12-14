/**
 * 
 */
package com.im.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.im.collection.ClaimDetails;

/**
 * @author khatwani_s
 *
 */
public interface ClaimRepository extends MongoRepository<ClaimDetails, String> {

}
