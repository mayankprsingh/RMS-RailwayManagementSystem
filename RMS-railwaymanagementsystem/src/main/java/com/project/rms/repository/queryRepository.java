package com.project.rms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.rms.model.Query;

public interface queryRepository extends MongoRepository<Query, String> {

}
