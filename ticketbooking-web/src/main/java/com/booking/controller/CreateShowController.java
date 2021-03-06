package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import com.booking.dto.MovieShowsDTO;
import com.booking.dto.MoviesDTO;
import com.booking.dto.TheatreScreensDTO;
import com.booking.model.ShowForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CreateShowController {
	
	@Autowired
	RestTemplate template;
	
	@GetMapping("/web/getCreateShow")
	public ModelAndView getAllShows(Model model) {
		log.info("CreateShowController - Get Span");
		ResponseEntity<List<TheatreScreensDTO>> screensListResponse=template
				.exchange("http://CLOUDGATEWAYMS/browseShows/getAllTheatreScreens", HttpMethod.GET,null,
						new ParameterizedTypeReference<List<TheatreScreensDTO>>() {});
		if(screensListResponse.getStatusCode() == HttpStatus.OK) {
			List<TheatreScreensDTO> screenList = screensListResponse.getBody();
	        log.info("Available screens: "+screenList.size());
	        model.addAttribute("screenList",screenList);
	    } else {
	        log.error("No Screens");
	        return new ModelAndView("error");
	    }
		
		ResponseEntity<List<MoviesDTO>> moviesListResponse=template
				.exchange("http://CLOUDGATEWAYMS/browseShows/getAllMovies", HttpMethod.GET,null,
						new ParameterizedTypeReference<List<MoviesDTO>>() {});
		if(screensListResponse.getStatusCode() == HttpStatus.OK) {
			List<MoviesDTO> moviesList = moviesListResponse.getBody();
	        log.info("Available movies: "+moviesList.size());
	        model.addAttribute("moviesList",moviesList);
	    } else {
	        log.error("No Movies");
	        return new ModelAndView("error");
	    }
		return new ModelAndView("createShow","movieShowForm",new ShowForm());
	}
	
	@PostMapping("/web/createShow")
	public ModelAndView createShows(Model model,
			@ModelAttribute("movieShowForm")ShowForm moviewShowModel  ) {
		log.info("CreateShowController - Post Span");
		MovieShowsDTO requestDTO=getDTOFromForm(moviewShowModel);
		ResponseEntity<MovieShowsDTO> moviesShowResponse=template
				.postForEntity("http://CLOUDGATEWAYMS/theatreShows/createShow",requestDTO,
						MovieShowsDTO.class);
		if(moviesShowResponse.getStatusCode() == HttpStatus.OK) {
			MovieShowsDTO showDTOResponse=moviesShowResponse.getBody();
			model.addAttribute("show",showDTOResponse);
		}else {
			log.error("Create Show Failed");
	        return new ModelAndView("error");
		}
		return new ModelAndView("createShowSuccess");
	}
	
	private MovieShowsDTO  getDTOFromForm(ShowForm form) {
		return MovieShowsDTO.builder()
				.showDate(form.getShowDate())
				.showTime(form.getShowTime())
				.showStatus("OPEN")
				.theatreScreen(TheatreScreensDTO.builder().id(form.getTheatreScreenId()).build())
				.movie(MoviesDTO.builder().id(form.getMovieId()).build())
				.build();
				
	}

}
