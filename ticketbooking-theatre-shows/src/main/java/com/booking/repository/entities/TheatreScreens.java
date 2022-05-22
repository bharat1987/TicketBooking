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
@Document("theatre_screens")
public class TheatreScreens {
	
	@Id
	private String id;
	
	@DocumentReference
	private Theatres theatre;  
	
	private String screenName;
	
	//@DocumentReference(lazy=true)
	//private List<MovieShows> showList;

	//seat plan
	
}