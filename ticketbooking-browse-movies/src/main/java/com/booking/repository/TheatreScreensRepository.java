package com.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booking.repository.entities.TheatreScreens;

public interface TheatreScreensRepository extends MongoRepository<TheatreScreens, String>{

}
