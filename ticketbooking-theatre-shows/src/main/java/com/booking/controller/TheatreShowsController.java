package com.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.MovieShowsDTO;
import com.booking.exception.InvalidDataException;
import com.booking.service.MasterDataService;
import com.booking.service.MovieShowsService;

@RestController
public class TheatreShowsController {
	
	@Autowired
	private MovieShowsService showService;
	
	@Autowired
	private MasterDataService masterService;
	
	@PostMapping("/theatreShows/createShow")
	public MovieShowsDTO createShow(@RequestBody MovieShowsDTO dto) {
		if(dto.getTheatreScreen().getId()==null||dto.getMovie().getId()==null) {
			throw new InvalidDataException("Invalid theatre or movie value provided.");
		}
		return showService.createShow(dto);
	}
	
	@PutMapping("/theatreShows/updateShow")
	public void updateeShow(@RequestBody MovieShowsDTO dto) {
		if(dto.getTheatreScreen().getId()==null||dto.getMovie().getId()==null) {
			throw new InvalidDataException("Invalid theatre or movie value provided.");
		}
		showService.updateShow(dto);
	}
	
	@DeleteMapping("/theatreShows/deleteShow/{id}")
	public void deleteShow(@PathVariable String id) {
		showService.deleteShow(id);
	}
	
	@PostMapping("/theatreShows/loadMasterData")
	public void loadData() {
		masterService.loadMasterData();
	}

}
