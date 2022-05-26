package com.booking.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dto.MovieShowsDTO;
import com.booking.exception.InvalidDataException;
import com.booking.repository.MovieShowsRepository;
import com.booking.repository.MoviesRepository;
import com.booking.repository.TheatreScreensRepository;
import com.booking.repository.entities.MovieShows;
import com.booking.repository.entities.Movies;
import com.booking.repository.entities.TheatreScreens;
import com.booking.service.MovieShowsService;

@Service
public class MovieShowsServiceImpl implements MovieShowsService{
	
	@Autowired
	private MovieShowsRepository repo;
	
	@Autowired
	private MoviesRepository moviesRepo;
	
	@Autowired
	private TheatreScreensRepository screenRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public MovieShowsDTO createShow(MovieShowsDTO dto) {
		MovieShows movieShows=mapper.map(dto,MovieShows.class);
		
		updateMovieAndScreen(movieShows);
		
		return mapper.map(repo.save(movieShows),MovieShowsDTO.class);
	}

	private void updateMovieAndScreen(MovieShows movieShows) {
		Optional<Movies> movieOpt=moviesRepo.findById(movieShows.getMovie().getId());
		Optional<TheatreScreens> screenOpt=screenRepo.findById(movieShows.getTheatreScreen().getId());
		if(movieOpt.isPresent() && screenOpt.isPresent()) {
			movieShows.setMovie(movieOpt.get());
			movieShows.setTheatreScreen(screenOpt.get());
		}else {
			new InvalidDataException("Invalid movie or theatre id provided.");
		}
	}
	
	public void updateShow(MovieShowsDTO dto) {
		MovieShows movieShows=mapper.map(dto,MovieShows.class);		
		updateMovieAndScreen(movieShows);
		repo.save(movieShows);
	}
	
    public void deleteShow(String id) {
    	repo.findById(id).ifPresentOrElse((value)->{repo.delete(value);},
    			()->{throw new InvalidDataException("Invalid Show Id. Delete Failed.");});
    	
	}
    
    
	

}
