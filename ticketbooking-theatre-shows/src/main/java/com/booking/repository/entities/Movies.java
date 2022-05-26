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
@Document("movies")
public class Movies {
	
	@Id
	private String id;
	
	private String movieName;
	
	private String language;
	
	//@DocumentReference
	//private List<MovieShows> showList;

}
