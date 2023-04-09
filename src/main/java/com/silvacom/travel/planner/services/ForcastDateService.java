package com.silvacom.travel.planner.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForcastDateService {
	
	@Autowired 
	WeatherService weatherService;

    public List<LocalDate> getDates() {
    	List<LocalDate> dates= List.of(
    			LocalDate.now(),
    			LocalDate.now().plusDays(1),
    			LocalDate.now().plusDays(2)
    			);
        return dates;
    }
    
}
