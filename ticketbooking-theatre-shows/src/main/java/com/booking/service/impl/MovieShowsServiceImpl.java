package com.booking.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.dto.MovieShowsDTO;
import com.booking.repository.MovieShowsRepository;
import com.booking.repository.entities.MovieShows;
import com.booking.service.MovieShowsService;

@Service
public class MovieShowsServiceImpl implements MovieShowsService{
	
	@Autowired
	private MovieShowsRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	public MovieShowsDTO createShow(MovieShowsDTO dto) {
		MovieShows movieShows=mapper.map(dto,MovieShows.class);		
		return mapper.map(repo.save(movieShows),MovieShowsDTO.class);
	}
	
	public void updateShow(MovieShowsDTO dto) {
		MovieShows movieShows=mapper.map(dto,MovieShows.class);		
		repo.save(movieShows);
	}
	
    public void deleteShow(String id) {
    	repo.deleteById(id);
	}
    
    
	

}
