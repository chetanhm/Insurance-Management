package com.respository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.UserRegistration;


public interface Repository extends MongoRepository<UserRegistration, String> {

}
