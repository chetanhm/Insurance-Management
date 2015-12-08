package com.userlogin;

import static org.junit.Assert.*;
import org.junit.Test;

import com.userlogin.collections.UserRegistration;

public class UserRegistrationTest {
	
	
	String userName="kanak";
	String emailId="kanak@soni.com";
	String password="kanak123";
	
	UserRegistration userRegistration = new UserRegistration(userName,emailId,password);
	
	@Test
	public void testCollectionData()
	{
		
		//assertEquals(userName, userRegistration.);
	}
}
