package com.silvacom.travel.planner.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.silvacom.tarvel.planner.dto.CityDTO;

/**
 * This class represents a simple POJO with group of weather info fields.
 * @author hdholariya
 *
 */
/**
 * @author dell
 *
 */
@Repository
public class CityRepository {
	
	/**
	 * The list of city information
	 */
	List<CityDTO> cities = new ArrayList<CityDTO>();
	
	/**
	 * The instance block of city information
	 */
	{
    	cities = List.of(
                new CityDTO("Edmonton", "Edmonton", "Edmonton is the fifth largest city in Canada and the capital city of the province of Alberta. We are one of the youngest and fastest-growing cities in the country. Edmonton is located on the North Saskatchewan River and is the northernmost city in North America with a population over one million people.", null),
                new CityDTO("Calgary", "Calgary", "Calgary is home to more than 1.4 million people. Our citizens are young: the median age of Calgarians is only 37.2 years. Calgary is the third most diverse major city in Canada with more than 120 languages spoken in the city. Calgary is 848 square kilometres in size, or 327 square miles.", null),
                new CityDTO("Toronto", "Toronto", "Toronto is Canada's largest city and a world leader in such areas as business, finance, technology, entertainment and culture.", null),
                new CityDTO("Montreal", "Montreal", "Montreal is Canada's second largest city and is home to nearly half of the province of Quebec's population. It is the metropolis of the province and was the most populous city in Canada for a century and a half.", null),
                new CityDTO("Vancouver", "Vancouver", "The City of Vancouver is a coastal, seaport city on the mainland of British Columbia. Located on the western half of the Burrard Peninsula, Vancouver is bounded to the north by English Bay and the Burrard Inlet and to the south by the Fraser River.", null)
        );
    }
    
    /**
     * The Getter method for cities field.
     * @return The list of cities
     */
    public List<CityDTO> getAllCities() {
        return cities;
    }
    
    /**
     * This method generate city's information by city name
     * @param cityName The name of the city
     * @return The instance of CityDTO
     */
    public Optional<CityDTO> findByCityName(String cityName) {
        return cities.stream().filter(city -> city.getName().equalsIgnoreCase(cityName)).findFirst();
    }

}
