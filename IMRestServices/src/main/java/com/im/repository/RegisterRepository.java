package com.im.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.im.collection.UserDetails;

public interface RegisterRepository extends MongoRepository<UserDetails, String> {

}
