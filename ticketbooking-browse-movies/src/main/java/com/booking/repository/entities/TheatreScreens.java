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
@Document("theatre_screens")
public class TheatreScreens {
	
	@Id
	private String id;
	
	private Theatres theatre;  
	
	private String screenName;
	
	//@DocumentReference(lazy=true)
	//private List<MovieShows> showList;

	//seat plan
	
}
