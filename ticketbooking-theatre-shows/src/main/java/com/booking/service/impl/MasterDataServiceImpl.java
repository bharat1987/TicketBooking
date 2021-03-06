package com.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.repository.LocationRepository;
import com.booking.repository.MovieShowsRepository;
import com.booking.repository.MoviesRepository;
import com.booking.repository.TheatreScreensRepository;
import com.booking.repository.TheatresRepository;
import com.booking.repository.entities.Location;
import com.booking.repository.entities.MovieShows;
import com.booking.repository.entities.Movies;
import com.booking.repository.entities.TheatreScreens;
import com.booking.repository.entities.Theatres;
import com.booking.service.MasterDataService;

@Service
public class MasterDataServiceImpl implements MasterDataService{

	@Autowired
	private TheatresRepository repo;
	
	@Autowired
	private TheatreScreensRepository screenRepo;
	
	@Autowired
	private MoviesRepository movieRepo;
	
	@Autowired
	private MovieShowsRepository showRepo;
	
	@Autowired
	private LocationRepository locRepo;
 	
	@Override
	public void loadMasterData() {
		/*Movies Master Data*/
		List<Movies> movieList=new ArrayList<Movies>();
		Movies movie=Movies.builder().movieName("F3").language("Telugu").build();
		movieList.add(movie);
		
		Movies movie2=Movies.builder().movieName("Top Gun").language("English").build();
		movieList.add(movie2);
		
		Movies movie3=Movies.builder().movieName("RRR").language("Telugu").build();
		movieList.add(movie3);
		
		Movies movie4=Movies.builder().movieName("RRR").language("Hindi").build();
		movieList.add(movie4);
		
		movieRepo.saveAll(movieList);
		/*Movies Master Data End*/
		
		/*Location Master Data Start*/
		List<Location> locationList=new ArrayList<Location>();
		Location loc1=Location.builder()
				.city("Hyderabad")
				.place("Punjagutta")
				.country("India")
				.build();
		locationList.add(loc1);
		
		Location loc2=Location.builder()
				.city("Hyderabad")
				.place("Nizampet")
				.country("India")
				.build();
		locationList.add(loc2);
		
		Location loc3=Location.builder()
				.city("Bangalore")
				.place("Majestic")
				.country("India")
				.build();
		locationList.add(loc3);
		
		locRepo.saveAll(locationList);
		/*Location Master Data Start*/
		
		/*Theatre and Theatre Screen Master Data*/
		List<Theatres> theatreList=new ArrayList<Theatres>();
		List<TheatreScreens> screensList=new ArrayList<TheatreScreens>();
		
		Theatres theatreEntity=Theatres.builder().name("PVR")
				.status("Active")
				.location(loc1)
				.build();
		
		TheatreScreens screen=  TheatreScreens
				.builder()
				.screenName("Atom1")
				.theatre(theatreEntity)
				.build();
		screensList.add(screen);
		
		TheatreScreens screen2=  TheatreScreens
				.builder()
				.screenName("Atom2")
				.theatre(theatreEntity)
				.build();
		screensList.add(screen2);
		
		
		theatreList.add(theatreEntity);
		
		
		Theatres theatreEntity2=Theatres.builder().name("Mallikarjuna")
				.location(loc2)
				.status("Active")
				.build();
		
		TheatreScreens screen3=  TheatreScreens
				.builder()
				.screenName("Screen1")
				.theatre(theatreEntity2)
				.build();
		screensList.add(screen3);
		
		
		theatreList.add(theatreEntity2);
		
		Theatres theatreEntity3=Theatres.builder().name("Inox")
				.location(loc3)
				.status("Active")
				.build();
		theatreList.add(theatreEntity3);
		
		TheatreScreens screen4=  TheatreScreens
				.builder()
				.screenName("A1")
				.theatre(theatreEntity3)
				.build();
		screensList.add(screen4);
		
		TheatreScreens screen5=  TheatreScreens
				.builder()
				.screenName("A2")
				.theatre(theatreEntity3)
				.build();
		screensList.add(screen5);
		repo.saveAll(theatreList);
		screenRepo.saveAll(screensList);
		
		/*Theatre and Theatre Screen Master Data*/
	    
		/*Movie Show Master Data*/
		MovieShows show= MovieShows.builder()
				.showDate("27-May-2022")
				.showTime("06:00")
				.theatreScreen(screen)
				.movie(movie)
				.build();
		showRepo.save(show);
		/*Movie Show Master Data*/
		
		
		
		
	}
	
	

}
