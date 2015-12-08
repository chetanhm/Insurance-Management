package com.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.UserRegisterPojo;
import com.mongo.UserRegistration;
import com.respository.RegisterRepository;
import com.respository.Repository;
@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterRepository registerRepo;
	@Autowired
	private Repository registrationRepository;

	public void save(UserRegisterPojo register) {
		registerRepo.save(register);
		
		System.out.println("Data Saved....Impl");
		
	}

	public void delete(String userName)
	{
		List<UserRegistration> users=registrationRepository.findAll();
		Iterator<UserRegistration> itr=users.iterator(); 
		List<UserRegistration> userlist =users;
		System.out.println("UserList: "+userlist);
	
		while(itr.hasNext())
		{
			UserRegistration ur=itr.next();
			String name=ur.getUserName();
			System.out.println("name="+name);
			String id=ur.getId();
			
		if(name.equals(userName))
		{
			
			userlist.remove(ur);
			System.out.println("Deleted userList: "+userlist);
			//registrationRepository.delete(id);
		}
		
		}
		
	}
		
	}


