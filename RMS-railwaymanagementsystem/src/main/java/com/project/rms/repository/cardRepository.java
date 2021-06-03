package com.project.rms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.rms.model.Card;

public interface cardRepository extends MongoRepository<Card, String>{
	
}
