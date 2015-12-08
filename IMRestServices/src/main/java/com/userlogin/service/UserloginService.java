package com.userlogin.service;

import com.userlogin.collections.UserRegistration;
import com.userlogin.entity.User;

public interface UserloginService {
	
	public UserRegistration getUser(String userName, String password);
}
