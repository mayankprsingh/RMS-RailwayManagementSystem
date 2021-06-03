package com.project.rms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.rms.model.Ticket;

public interface ticketRepository extends MongoRepository<Ticket, String> {

}
