package com.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TicketbookingCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketbookingCloudConfigApplication.class, args);
	}

}
