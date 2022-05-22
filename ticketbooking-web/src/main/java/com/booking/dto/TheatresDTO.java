package com.booking.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheatresDTO {
	
	private String id;
	
	private String name;
	
	private String city;
	
	private String status;
	
	private String place;
	
	private String Country;
	
	//private List<TheatreScreensDTO> screenList;  
	
	//Geo lat long 

}
