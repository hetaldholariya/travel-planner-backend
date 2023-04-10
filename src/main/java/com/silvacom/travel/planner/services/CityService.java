package com.silvacom.travel.planner.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silvacom.tarvel.planner.dto.CityDTO;
import com.silvacom.travel.planner.repository.CityRepository;

/**
 * This class Indicates that this is a Spring service bean.
 * @author hdholariya
 *
 */
@Service
public class CityService {
	
	/**
	 * The instance of CityRepository
	 */
	@Autowired
	private CityRepository cityRepository;
	
	/**
	 * The instance of WeatherService
	 */
	@Autowired 
	WeatherService weatherService;

    /**
     * Retrieves The list of city.
     * @return The list of city.
     */
    public List<CityDTO> getCities() {
    	List<CityDTO> cities= cityRepository.getAllCities();
    	if(!cities.isEmpty()) {
    		cities.forEach(city -> city.setWeather(weatherService.weatherForecastAverage(city.getName(), LocalDate.now())));
    	}
        return cityRepository.getAllCities();
    }
    
    /**
     * Retrieves a city by their name and date.
     * @param cityName The name of the city
     * @param date The Date 
     * @return The instance of CityDTO
     */
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
