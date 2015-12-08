package com.im.service;

import com.im.collection.UserDetails;


public interface UserLoginService {
	
	public com.im.collection.UserDetails getUser(String userName, String password);
}
