package com.userlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userlogin.collections.UserRegistration;
import com.userlogin.entity.User;
import com.userlogin.repository.UserRepository;

@Service
public class UserloginServiceImpl implements UserloginService{

	@Autowired
	private UserRepository userRepository;
	
	public UserRegistration getUser(String userName) 
	{
		return userRepository.findOne(userName);		 	
	}
}	
