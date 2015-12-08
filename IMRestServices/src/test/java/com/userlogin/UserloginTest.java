package com.userlogin;

import static org.junit.Assert.*;

import org.junit.Test;

import com.userlogin.entity.User;

public class UserloginTest {
	
	   String message = "Hello World";
	   String userName="";
	   String emailId="";
	   String password="";
	   
	   User user = new User(userName,emailId,password);

	   @Test
	   public void testUserData() {
	      assertEquals(userName,user.getUserName());
	      assertEquals(emailId,user.getEmailId());
	      assertEquals(password,user.getPassword());
	   }
	}


