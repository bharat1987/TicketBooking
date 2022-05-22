package com.booking.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDTO {
	
	private String id;
	
	private String movieName;
	
	private String language;
	
	//private List<MovieShowsDTO> showList;


}
