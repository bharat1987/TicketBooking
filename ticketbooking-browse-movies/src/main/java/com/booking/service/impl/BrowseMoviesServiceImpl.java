package com.booking.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dto.LocationDTO;
import com.booking.dto.MovieShowsDTO;
import com.booking.dto.MoviesDTO;
import com.booking.dto.TheatreScreensDTO;
import com.booking.repository.LocationRepository;
import com.booking.repository.MovieShowsRepository;
import com.booking.repository.MoviesRepository;
import com.booking.repository.TheatreScreensRepository;
import com.booking.repository.entities.MovieShows;
import com.booking.service.BrowseMoviesService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BrowseMoviesServiceImpl implements BrowseMoviesService{
	
	@Autowired
	private MovieShowsRepository showsRepo;
	
	@Autowired
	private MoviesRepository moviesRepo;
	
	@Autowired
	private TheatreScreensRepository screensRepo;
	
	@Autowired
	private LocationRepository locationRepo;
	
	
	@Autowired
	private ModelMapper mapper;
	
	public List<MovieShowsDTO> getAllShows() {
		
		return showsRepo.findAll().stream().map(show->mapper.map(show,MovieShowsDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<MoviesDTO> getAllMovies() {
		return moviesRepo.findAll().stream().map(movie->mapper.map(movie,MoviesDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<TheatreScreensDTO> getAllScreens() {
		return screensRepo.findAll().stream().map(screen->mapper.map(screen,TheatreScreensDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<String> getAllLocations() {
		
		return locationRepo.getDistinctCity();
	}

	@Override
	public List<MovieShowsDTO> getTheatresByMovieLocationAndTime(String movie, String location, String date) {
		
		List<MovieShowsDTO> showsList=showsRepo.findShowsByMovieLocationAndDate(movie, location, date).stream()
		.map(show->mapper.map(show,MovieShowsDTO.class))
		.collect(Collectors.toList());
		log.info("Total list values"+showsList.size());
		return showsList;
	}

}
