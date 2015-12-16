package com.im.service;

import java.util.List;

import com.im.collection.UserDetails;
import com.im.entity.Registration;

public interface UserDetailsService {
	
	public UserDetails insertUser(UserDetails register);
	public void deleteUser(String n);
	public UserDetails loginUser(String userName, String password);
	public UserDetails getUserByUsername(String userName);
	public UserDetails getUserByEmail(String email);
	public UserDetails saveUser(UserDetails userDetails);
	public UserDetails getUserById(String id);
	public UserDetails logoutUser(String id);
	public UserDetails registerManagedCustomer(Registration managedCustomer,String agentUserName);
	public UserDetails setAgentStatus(String userName, String userType);
	public List<UserDetails> getUserByAgentName(String agentUserName);
}
