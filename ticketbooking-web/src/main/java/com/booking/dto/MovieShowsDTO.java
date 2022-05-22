package com.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@NoArgsConstructor
@AllArgsConstructor
public class MovieShowsDTO {
	
	private String id;
	
	private String showTime;
	
	private String showDate;
	
	private String showStatus;
	
    private MoviesDTO movie;	

	private TheatreScreensDTO theatreScreen;
	
}
