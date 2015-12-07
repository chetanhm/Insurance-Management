package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.user.UserRegistration;

public interface RegistrationRepository extends MongoRepository<UserRegistration, String> {
}
