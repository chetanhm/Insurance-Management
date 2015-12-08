package com.im.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.collection.UserDetails;
import com.im.repository.RegisterRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	private RegisterRepository registerRepository;

	public void insertUser(UserDetails register) {
		registerRepository.insert(register);

	}

	public void deleteUser(String userName) {

		registerRepository.delete(userName);

	}
	public com.im.collection.UserDetails getUser(String userName, String password) {
		List<UserDetails> userList = registerRepository.findAll();
		Iterator<UserDetails> itr = userList.iterator();
		while (itr.hasNext()) {
			if (userName.equals(itr.next().getUsername()) && password.equals(itr.next().getPassword())) {
				return registerRepository.findOne(userName);
			}
		}
		return null;
	}

}
