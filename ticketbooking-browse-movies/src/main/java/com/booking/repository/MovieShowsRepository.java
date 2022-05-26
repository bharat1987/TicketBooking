package com.booking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.booking.repository.entities.MovieShows;

public interface MovieShowsRepository extends MongoRepository<MovieShows, String> {
	
	@Query("{'movie.movieName':?0,'theatreScreen.theatre.location.city' : ?1,'showDate':?2}")
	public List<MovieShows> findShowsByMovieLocationAndDate(String movieName,String city,String date);

}
