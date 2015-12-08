package com.userlogin.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userlogin.collections.UserRegistration;
import com.userlogin.entity.User;
import com.userlogin.repository.UserRepository;

@Service
public class UserloginServiceImpl implements UserloginService{

	@Autowired
	private UserRepository userRepository;
	
	public UserRegistration getUser(String userName,String password) 
	{
		List<UserRegistration> userList = userRepository.findAll();
		Iterator<UserRegistration> itr = userList.iterator();
		while(itr.hasNext())
		{
			if(userName.equals(itr.next().getUserName())&& password.equals(itr.next().getPassword()) )
			{
				return userRepository.findOne(userName);
			}
		}
		return null;		 	
	}

	
}	
