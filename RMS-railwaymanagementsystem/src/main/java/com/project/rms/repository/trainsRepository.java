package com.project.rms.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.rms.model.Trains;

public interface trainsRepository extends MongoRepository<Trains, String>{
	
	List<Trains> findByTrainRunningDate(String trainRunningDate);

}
