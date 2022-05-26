package com.booking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.repository.entities.Location;

public interface LocationRepository extends MongoRepository<Location, String>{
	
	@Aggregation(pipeline = { "{ '$group': { '_id' : '$city' } }" })
	public List<String> getDistinctCity();

}
