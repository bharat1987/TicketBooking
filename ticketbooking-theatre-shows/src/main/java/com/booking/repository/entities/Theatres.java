package com.booking.repository.entities;

import java.util.List;

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
	
	private String city;
	
	private String status;
	
	private String place;
	
	private String country;
	
	//@DocumentReference
	//private List<TheatreScreens> screenList;  
	
	//Geo lat long 

}
