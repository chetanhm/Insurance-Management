package com.service;

import com.mongo.UserRegisterPojo;
import com.userlogin.entity.User;

public interface RegisterService {
	
	public void save(UserRegisterPojo register);
	public void delete(String n);

}
