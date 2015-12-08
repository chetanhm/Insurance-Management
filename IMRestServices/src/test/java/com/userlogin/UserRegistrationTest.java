package com.userlogin;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.im.collection.UserDetails;
import com.im.repository.RegisterRepository;


public class UserRegistrationTest {
	
	
	String userName="kanak";
	String emailId="kanak@soni.com";
	String password="kanak123";
	
	
	private RegisterRepository userRepository;
	UserDetails userRegistration = new UserDetails(userName,emailId,password, emailId, emailId, emailId, emailId, emailId, emailId);
	
	public void save(UserDetails userRegistration)
	{
		
		userRepository.save(userRegistration);
	}
		
	@Test
	public void testCollectionData()
	{
		UserDetails ur = userRepository.findOne(userName);
		assertEquals(userName, ur.getUsername());
	}
}
