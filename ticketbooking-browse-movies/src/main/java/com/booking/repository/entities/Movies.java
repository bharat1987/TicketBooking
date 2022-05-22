package com.booking.repository.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document("movies")
public class Movies {
	
	@Id
	private String id;
	
	private String movieName;
	
	private String language;
	
	//@DocumentReference
	//private List<MovieShows> showList;

}
