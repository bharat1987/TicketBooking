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
public class TheatreScreensDTO {
	
	private String id;
	
	private TheatresDTO theatre;  
	
	private String screenName;
	
	//private List<MovieShowsDTO> showList;

	//seat plan
	
}
