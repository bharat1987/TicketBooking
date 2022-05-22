package com.booking.repository.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document("movies_shows")
public class MovieShows {
	
	@Id
	private String id;
	
	private String showTime;
	
	private String showDate;
	
	private String showStatus;
	
	@DocumentReference
    private Movies movie;	

	@DocumentReference
	private TheatreScreens theatreScreen;
	
}