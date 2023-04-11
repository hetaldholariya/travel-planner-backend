package com.silvacom.travel.planner.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silvacom.tarvel.planner.dto.CityDTO;
import com.silvacom.travel.planner.services.CityService;

/**
 * This class is a controller for handling HTTP requests
 * @author hdholariya
 *
 */
@CrossOrigin(origins = "https://travel-planner-frontend-2.azurewebsites.net/")
@RestController
// The base path for all endpoints in this controller
@RequestMapping("/api")
public class CityController {

	/**
	 * The instance of CityService.
	 */
	@Autowired
	CityService cityService;
	
	/**
	 * Handle GET requests to "/api/cities
	 * @return The instance of ResponseEntity
	 */
	@GetMapping("/cities")
	public ResponseEntity<List<CityDTO>> getAllCities() {
		try {
			List<CityDTO> cities= cityService.getCities();
			if (cities.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(cities, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Handle GET requests to "/api/city
	 * @param name The name of the city
	 * @param date The date for weather prediction
	 * @return The instance of ResponseEntity
	 */
	@GetMapping("/city")
	public ResponseEntity<CityDTO> getCityByName(@RequestParam(required = false) String name, @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		
		if (name != null && date!= null) {
			CityDTO city = cityService.getCityByNameAndDate(name, date);
			return new ResponseEntity<>(city, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
