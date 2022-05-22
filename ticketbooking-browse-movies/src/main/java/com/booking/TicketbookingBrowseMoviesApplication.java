package com.booking;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class TicketbookingBrowseMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketbookingBrowseMoviesApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper(){
	    return new ModelMapper();
	}


}
