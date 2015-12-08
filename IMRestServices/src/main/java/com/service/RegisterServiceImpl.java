package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mongo.UserRegisterPojo;
import com.respository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private RegisterRepository registerRepo;

	public void save(UserRegisterPojo register) {
		registerRepo.save(register);
		
		System.out.println("Data Saved....Impl");
		
	}

	public void delete(String n) {
		
		
	}

}
