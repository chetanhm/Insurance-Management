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

	public UserDetails getUserById(String id) {
		return registerRepository.findOne(id);

	}

	public UserDetails logoutUser(String id)
	{
		UserDetails userDetails = registerRepository.findOne(id);
		if(userDetails!=null)
		{
			userDetails.setLoginStatus("Logged Out");
			registerRepository.save(userDetails);
			return userDetails;
		}
		else
		{
			return null;
		}
		
	}
	public void deleteUser(String userName) {

		registerRepository.delete(userName);

	}

	public UserDetails saveUser(UserDetails userDetails) {
		return registerRepository.save(userDetails);
	}

	public UserDetails loginUser(String userName, String password) {

		UserDetails userDetails = registerRepository.findByUserName(userName);
		if (userDetails != null) {

			if (userDetails.getPassword().equals(password)) {
				userDetails.setLoginStatus("Logged In");
				registerRepository.save(userDetails);
				return userDetails;
			} else {
				return null;
			}
		} else {
			return null;

		}
	}

	public com.im.collection.UserDetails getUserByUsername(String userName) {

		UserDetails userDetails = registerRepository.findByUserName(userName);

		return userDetails;

	}

	public UserDetails getUserByEmail(String email) {
		return registerRepository.findByEmail(email);

	}

}
