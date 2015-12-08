package com.userlogin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.userlogin.entity.User;

public class UserloginTest {
	
	   String message = "Hello World";
	   String userName="john";
	   String emailId="john@samsung.com";
	   String password="john123";
	 
	   User user = new User(userName,emailId,password);

	   @Test
	   public void testUserData() {
	      assertEquals(userName,user.getUserName());
	      assertEquals(emailId,user.getEmailId());
	      assertEquals(password,user.getPassword());
	   }
	}


