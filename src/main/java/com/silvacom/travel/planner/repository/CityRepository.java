package com.silvacom.travel.planner.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.silvacom.tarvel.planner.dto.CityDTO;

@Repository
public class CityRepository {
	
	List<CityDTO> cities = new ArrayList<CityDTO>();
	

	{
    	cities = List.of(
                new CityDTO("Edmonton", "Edmonton", "Alberta", null),
                new CityDTO("Calgary", "Calgary", "sada", null),
                new CityDTO("Toronto", "Toronto", "sd", null),
                new CityDTO("Montreal", "Montreal", "sd", null),
                new CityDTO("Vancouver", "Vancouver", "sd", null)
        );
    }
    
    public List<CityDTO> getAllCities() {
        return cities;
    }
    
    public Optional<CityDTO> findByCityName(String cityName) {
        return cities.stream().filter(city -> city.getName().equalsIgnoreCase(cityName)).findFirst();
    }

}
