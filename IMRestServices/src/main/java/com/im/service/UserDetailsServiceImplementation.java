package com.im.service;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.im.collection.UserDetails;
import com.im.repository.RegisterRepository;
import com.mongodb.Mongo;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	private RegisterRepository registerRepository;

	public void insertUser(UserDetails register) {
		registerRepository.insert(register);

	}

	public void deleteUser(String userName) {

		registerRepository.delete(userName);

	}

	public com.im.collection.UserDetails getUser(String userName, String password) {
		MongoOperations mongoOps = null;
		try {
			mongoOps = new MongoTemplate(new Mongo(), "test");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		UserDetails userDetails = mongoOps.findOne(new Query(Criteria.where("username").is(userName)),
				UserDetails.class);
		if (userDetails.getPassword().equals(password)) {
			return userDetails;
		} else {
			return null;
		}
	}

}
