package com.silvacom.tarvel.planner.dto;

import java.io.Serializable;

/**
 * @author hdholariya
 *
 */
public class CityDTO implements Serializable{
	
	private static final long serialVersionUID = 5763148931413501363L;
	
	private String name;
	private String label;
	private String description;
	private WeatherAverageDTO weather;
	
	public CityDTO() {
		super();
	}
	
	public CityDTO(String name, String label, String description, WeatherAverageDTO weather) {
		super();
		this.name = name;
		this.label = label;
		this.description = description;
		this.weather = weather;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public WeatherAverageDTO getWeather() {
		return weather;
	}

	public void setWeather(WeatherAverageDTO weather) {
		this.weather = weather;
	}
	
}
