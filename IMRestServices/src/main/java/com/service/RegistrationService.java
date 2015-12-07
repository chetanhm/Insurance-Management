package com.service;

import com.user.UserRegistration;

public interface RegistrationService {

	void save(UserRegistration userRegistration);

	void delete(String userName);


}
