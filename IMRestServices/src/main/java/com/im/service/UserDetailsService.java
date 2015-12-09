package com.im.service;

import com.im.collection.UserDetails;

public interface UserDetailsService {
	
	public UserDetails insertUser(UserDetails register);
	public void deleteUser(String n);
	public UserDetails getUserByUsername(String userName);
	public UserDetails getUserByEmail(String email);
}
