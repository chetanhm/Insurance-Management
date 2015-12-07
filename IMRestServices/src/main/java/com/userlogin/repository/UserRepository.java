package com.userlogin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userlogin.collections.UserRegistration;
import com.userlogin.entity.User;


public interface UserRepository extends MongoRepository<UserRegistration, String>{

//	public User findByUserName(String userName);
//	public User findByEmailId(String emailId);
}
