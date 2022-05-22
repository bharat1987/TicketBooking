package com.booking.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;

@Data
public class MoviesDTO {
	
	private String id;
	
	private String movieName;
	
	//private List<MovieShowsDTO> showList;


}