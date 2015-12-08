package com.userlogin;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.userlogin.collections.UserRegistration;
import com.userlogin.repository.UserRepository;

public class UserRegistrationTest {
	
	
	String userName="kanak";
	String emailId="kanak@soni.com";
	String password="kanak123";
	
	
	private UserRepository userRepository;
	UserRegistration userRegistration = new UserRegistration(userName,emailId,password);
	
	public void save(UserRegistration userRegistration)
	{
		userRepository.save(userRegistration);
	}
		
	@Test
	public void testCollectionData()
	{
		UserRegistration ur = userRepository.findOne(userName);
		assertEquals(userName, ur.getUserName());
	}
}
