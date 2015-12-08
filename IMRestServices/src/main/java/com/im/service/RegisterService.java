package com.im.service;

import com.im.collection.UserDetails;

public interface RegisterService {
	
	public void save(UserDetails register);
	public void delete(String n);

}
