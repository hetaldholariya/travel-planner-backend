package com.silvacom.travel.planner.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silvacom.travel.planner.services.ForcastDateService;

/**
 * This class is a controller for handling HTTP requests
 * @author hdholariya
 *
 */
@CrossOrigin(origins = "https://travel-planner-frontend-2.azurewebsites.net/")
@RestController
@RequestMapping("/api")
public class ForcastDateController {

	/**
	 * The instance of ForcastDateService
	 */
	@Autowired
	ForcastDateService forcastDateService;
		
	/**
	 * Handle GET requests to "/api/dates"
	 * @return The instance of ResponseEntity
	 */
	@GetMapping("/dates")
	public ResponseEntity<List<LocalDate>> forcastDates() {
		List<LocalDate> dates = forcastDateService.getDates();
		if (dates != null) {
			return new ResponseEntity<>(dates, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
