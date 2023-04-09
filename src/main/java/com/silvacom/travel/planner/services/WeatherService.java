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
@Service
public class WeatherService {

	private final String URI = "http://api.openweathermap.org/data/2.5/forecast";
	private final String API_ID = "0b4ba9ce32d3e8c1c8cda4898c290586";

	private final RestTemplate restTemplate;

	public WeatherService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Cached(expire = 10, timeUnit = TimeUnit.MINUTES)
	public WeatherAverageDTO weatherForecastAverage(String city, LocalDate date) {
		List<WeatherMapTimeDTO> collect = null;
		try {
			WeatherMapDTO weatherMap = this.restTemplate.getForObject(this.url(city), WeatherMapDTO.class);
				collect = weatherMap.getList().stream()
						.filter(x -> x.getDt().toLocalDate().equals(date)).collect(Collectors.toList());
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
		}

		return this.average(collect);
	}

	private WeatherAverageDTO average(List<WeatherMapTimeDTO> list) {
		WeatherAverageDTO result = new WeatherAverageDTO();

		for (WeatherMapTimeDTO item : list) {
			result.setDate(item.getDt().toLocalDate());
			result.plusMap(item);
		}

		result.totalize();

		return result;
	}

	private String url(String city) {
		return String.format(URI.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, API_ID);
	}

}
