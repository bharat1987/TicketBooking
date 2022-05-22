package com.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.repository.entities.MovieShows;

public interface MovieShowsRepository extends MongoRepository<MovieShows, String> {

}
