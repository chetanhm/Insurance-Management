package com.im.service;

import com.im.collection.UserDetails;

public interface UserDetailsService {
	
	public void insertUser(UserDetails register);
	public void deleteUser(String n);
	public UserDetails getUser(String userName, String password);
}
