package com.booking.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dto.MovieShowsDTO;
import com.booking.dto.MoviesDTO;
import com.booking.dto.TheatreScreensDTO;
import com.booking.repository.MovieShowsRepository;
import com.booking.repository.MoviesRepository;
import com.booking.repository.TheatreScreensRepository;
import com.booking.repository.entities.MovieShows;
import com.booking.service.BrowseMoviesService;

@Service
public class BrowseMoviesServiceImpl implements BrowseMoviesService{
	
	@Autowired
	private MovieShowsRepository showsRepo;
	
	@Autowired
	private MoviesRepository moviesRepo;
	
	@Autowired
	private TheatreScreensRepository screensRepo;
	
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

}
