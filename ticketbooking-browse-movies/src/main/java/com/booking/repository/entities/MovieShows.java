package com.booking.repository.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("movies_shows")
public class MovieShows {
	
	@Id
	private String id;
	
	private String showTime;
	
	private String showDate;
	
	private String showStatus;
	
    private Movies movie;	

	private TheatreScreens theatreScreen;
	
}
