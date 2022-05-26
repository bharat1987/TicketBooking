package com.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.repository.entities.Location;

public interface LocationRepository extends MongoRepository<Location, String>{

}
