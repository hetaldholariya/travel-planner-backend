package com.silvacom.travel.planner.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silvacom.tarvel.planner.dto.CityDTO;
import com.silvacom.travel.planner.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired 
	WeatherService weatherService;

    public List<CityDTO> getCities() {
    	List<CityDTO> cities= cityRepository.getAllCities();
    	if(!cities.isEmpty()) {
    		cities.forEach(city -> city.setWeather(weatherService.weatherForecastAverage(city.getName(), LocalDate.now())));
    	}
        return cityRepository.getAllCities();
    }
    
    public CityDTO getCityByNameAndDate(String cityName, LocalDate date) {
    	if(!cityName.isEmpty()) {
    		Optional<CityDTO> city = cityRepository.findByCityName(cityName);
    		if(city.isPresent()) {
        		city.get().setWeather(weatherService.weatherForecastAverage(cityName, date));
        		return city.get();
        	}
    	}
        return null;
    }
}
