package com.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.repository.entities.Movies;

public interface MoviesRepository extends MongoRepository<Movies, String> {

}
