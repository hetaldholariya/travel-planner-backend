package com.silvacom.travel.planner.services;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.alicp.jetcache.anno.Cached;
import com.silvacom.tarvel.planner.dto.WeatherAverageDTO;
import com.silvacom.tarvel.planner.dto.WeatherMapDTO;
import com.silvacom.tarvel.planner.dto.WeatherMapTimeDTO;

//https://github.com/marcosstefani/weather
//https://openweathermap.org/current#name
/**
 * This class Indicates that this is a Spring service bean.
 * @author hdholariya
 *
 */
@Service
public class WeatherService {

	/**
	 * Static URL for weather forcast API
	 */
	private final String URI = "http://api.openweathermap.org/data/2.5/forecast";
	
	/**
	 * API ID
	 */
	private final String API_ID = "0b4ba9ce32d3e8c1c8cda4898c290586";

	/**
	 * Instance of RestTemplate
	 */
	private final RestTemplate restTemplate;

	/**
	 * Constructor for creating a new WeatherService object
	 * @param restTemplateBuilder
	 */
	public WeatherService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	/**
	 * Generate aggregate weather information object
	 * @param cityName The name of the city
	 * @param date The date
	 * @return
	 */
	@Cached(expire = 10, timeUnit = TimeUnit.MINUTES)
	public WeatherAverageDTO weatherForecastAverage(String cityName, LocalDate date) {
		List<WeatherMapTimeDTO> collect = null;
		try {
			WeatherMapDTO weatherMap = this.restTemplate.getForObject(this.url(cityName), WeatherMapDTO.class);
				collect = weatherMap.getList().stream()
						.filter(x -> x.getDt().toLocalDate().equals(date)).collect(Collectors.toList());
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}

		return this.average(collect);
	}

	/**
	 * This method will fill up the WeatherAverageDTO object.
	 * @param list The list of WeatherMapTimeDTO object
	 * @return The instance of WeatherAverageDTO
	 */
	private WeatherAverageDTO average(List<WeatherMapTimeDTO> list) {
		WeatherAverageDTO result = new WeatherAverageDTO();

		for (WeatherMapTimeDTO item : list) {
			result.setDate(item.getDt().toLocalDate());
			result.plusMap(item);
		}

		result.totalize();

		return result;
	}

	/**
	 * This method will generate the dynamic URL.
	 * @param city The name of city
	 * @return The URL
	 */
	private String url(String city) {
		return String.format(URI.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, API_ID);
	}

}
