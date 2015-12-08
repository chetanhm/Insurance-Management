package com.respository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.UserRegisterPojo;

public interface RegisterRepository extends MongoRepository<UserRegisterPojo, String> {

}
