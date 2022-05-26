package com.booking.repository.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("theatres")
public class Theatres {
	
	@Id
	private String id;
	
	private String name;
	
	private Location location;
	
	private String status;
	
	//@DocumentReference
	//private List<TheatreScreens> screenList;  
	
	//Geo lat long 

}
