package com.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.UserRegistration;
import com.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public void save(UserRegistration userRegistration) {
		registrationRepository.save(userRegistration);
	}
	
	public void delete(String userName)
	{
		List<UserRegistration> users=registrationRepository.findAll();
		Iterator<UserRegistration> itr=users.iterator(); 
		List<UserRegistration> userlist =users;
		System.out.println("Delete userList: "+userlist);
	
		while(itr.hasNext())
		{
			UserRegistration activeUser=itr.next();
			String name=activeUser.getUserName();
			System.out.println("name="+name);
			String id=activeUser.getId();
			System.out.println("In Loop ");
		if(name.equals(userName))
		{
			System.out.println("Deleted record: "+id);
			userlist.remove(activeUser);
			System.out.println("userList: "+userlist);
			//To delete the record completely ->
			//registrationRepository.delete(id);
		}
		
		}
		
	}
	

	

	

}
