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

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ForcastDateController {

	@Autowired
	ForcastDateService forcastDateService;
		
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
