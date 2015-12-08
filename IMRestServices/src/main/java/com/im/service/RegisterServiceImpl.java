package com.im.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.collection.UserDetails;
import com.im.repository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepository registerRepo;

	public void save(UserDetails register) {
		registerRepo.save(register);

	}

	public void delete(String userName) {
		List<UserDetails> users = registerRepo.findAll();
		Iterator<UserDetails> itr = users.iterator();
		List<UserDetails> userlist = users;

		while (itr.hasNext()) {
			UserDetails ur = itr.next();
			String name = ur.getUsername();
			String id = ur.getId();

			if (name.equals(userName)) {

				userlist.remove(ur);
			}

		}

	}

}
