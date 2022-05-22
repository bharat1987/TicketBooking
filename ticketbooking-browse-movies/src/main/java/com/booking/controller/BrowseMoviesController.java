package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.MovieShowsDTO;
import com.booking.dto.MoviesDTO;
import com.booking.dto.TheatreScreensDTO;
import com.booking.service.BrowseMoviesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BrowseMoviesController {
	
	@Autowired
	private BrowseMoviesService service;
	
	
	@GetMapping("/browseShows/getAllShows")
	public List<MovieShowsDTO> getAllShows() {
		log.info("BrowseMoviesController - getAllShows");
		return service.getAllShows();
	}
	
	@GetMapping("/browseShows/getAllTheatreScreens")
	public List<TheatreScreensDTO> getAllScreens() {
		log.info("BrowseMoviesController - getAllScreens");
		return service.getAllScreens();
	}
	
	@GetMapping("/browseShows/getAllMovies")
	public List<MoviesDTO> getAllMovies() {
		log.info("BrowseMoviesController - getAllMovies");
		return service.getAllMovies();
	}

}