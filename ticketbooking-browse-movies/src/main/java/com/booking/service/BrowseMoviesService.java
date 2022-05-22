package com.booking.service;

import java.util.List;

import com.booking.dto.MovieShowsDTO;
import com.booking.dto.MoviesDTO;
import com.booking.dto.TheatreScreensDTO;

public interface BrowseMoviesService {
	
	public List<MovieShowsDTO>  getAllShows();

	public List<MoviesDTO> getAllMovies();

	public List<TheatreScreensDTO> getAllScreens();
	
}
