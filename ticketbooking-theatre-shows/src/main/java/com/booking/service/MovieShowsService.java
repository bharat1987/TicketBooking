package com.booking.service;

import com.booking.dto.MovieShowsDTO;
import com.booking.repository.entities.MovieShows;

public interface MovieShowsService {
	
	public MovieShowsDTO createShow(MovieShowsDTO dto) ;
	
	public void updateShow(MovieShowsDTO dto) ;
	
    public void deleteShow(String id);

}
