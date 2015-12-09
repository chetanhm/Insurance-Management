package com.im.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.collection.UserDetails;
import com.im.repository.RegisterRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	private RegisterRepository registerRepository;

	public UserDetails insertUser(UserDetails register) {
		return registerRepository.insert(register);

	}

	public void deleteUser(String userName) {

		registerRepository.delete(userName);

	}

	public UserDetails loginUser(String userName, String password) {

		UserDetails userDetails = registerRepository.findByUserName(userName);
		if (userDetails != null) {
			
			if (userDetails.getPassword().equals(password)) {	
				
				return userDetails;
				//return "{\"status\": \"ok\"}";
			} else {
				return null;
				//return "{\"status\": \"fail\"}";
			}
		} else {
			return null;
			//return "{\"status\":\"-1\"}";
		}
	}
	
	public com.im.collection.UserDetails getUserByUsername(String userName) {

		UserDetails userDetails = registerRepository.findByUserName(userName);

		return userDetails;

	}
	public UserDetails getUserByEmail(String email)
	{
		return registerRepository.findByEmail(email);
		
	}

}
