package com.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.repository.entities.Theatres;


public interface TheatresRepository extends MongoRepository<Theatres, String> {

}
