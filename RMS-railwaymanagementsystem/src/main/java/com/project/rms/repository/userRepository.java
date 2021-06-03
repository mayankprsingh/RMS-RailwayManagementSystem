package com.project.rms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.rms.model.User;

public interface userRepository extends MongoRepository<User, String> {
	
	User findByUserEmail(String userEmail);

}
