package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.LocationDTO;
import com.booking.dto.MovieShowsDTO;
import com.booking.dto.MoviesDTO;
import com.booking.dto.TheatreScreensDTO;
import com.booking.repository.entities.Location;
import com.booking.service.BrowseMoviesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/browseShows")
public class BrowseMoviesController {
	
	@Autowired
	private BrowseMoviesService service;
	
	
	@GetMapping("/getAllShows")
	public List<MovieShowsDTO> getAllShows() {
		log.info("BrowseMoviesController - getAllShows");
		return service.getAllShows();
	}
	
	@GetMapping("/getAllTheatreScreens")
	public List<TheatreScreensDTO> getAllScreens() {
		log.info("BrowseMoviesController - getAllScreens");
		return service.getAllScreens();
	}
	
	@GetMapping("/getAllMovies")
	public List<MoviesDTO> getAllMovies() {
		log.info("BrowseMoviesController - getAllMovies");
		return service.getAllMovies();
	}
	
	@GetMapping("/getAllLocations")
	public List<String> getAllLocations() {
		log.info("BrowseMoviesController - getAllLocations");
		return service.getAllLocations();
	}
	
	@GetMapping("/getShows/movie/{movie}/location/{location}/date/{date}")
	public List<MovieShowsDTO> getTheatresByMovieLocationAndTime(
			@PathVariable(value ="movie") String movie,
			@PathVariable(value ="location") String location,
			@PathVariable(value ="date") String date) {
		log.info("BrowseMoviesController - get all shows by theatre");
		return service.getTheatresByMovieLocationAndTime(movie,location,date);
	}

}
