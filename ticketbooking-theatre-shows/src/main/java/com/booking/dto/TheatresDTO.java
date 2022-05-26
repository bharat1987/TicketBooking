package com.booking.dto;

import lombok.Data;

@Data
public class TheatresDTO {
	
	private String id;
	
	private String name;
	
	private String status;
	
	private LocationDTO location;
	
	//private List<TheatreScreensDTO> screenList;  
	

}
