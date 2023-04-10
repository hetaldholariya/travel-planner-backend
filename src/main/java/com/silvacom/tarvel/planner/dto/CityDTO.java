package com.silvacom.tarvel.planner.dto;

import java.io.Serializable;

/**
 * This class represents a simple POJO with four fields: name, label, description, weather
 *  @author hdholariya
 */
public class CityDTO implements Serializable{
	
	private static final long serialVersionUID = 5763148931413501363L;
	
	private String name;
	private String label;
	private String description;
	private WeatherAverageDTO weather;
	
	/**
	 * Default constructor for creating a new CityDTO object.
	 */
	public CityDTO() {
		super();
	}
	
	/**
	 * Constructor for creating a new CityDTO object.
	 * @param name
	 * @param label
	 * @param description
	 * @param weather
	 */
	public CityDTO(String name, String label, String description, WeatherAverageDTO weather) {
		super();
		this.name = name;
		this.label = label;
		this.description = description;
		this.weather = weather;
	}
	
	/**
	 * Getter method for the name field.
	 * @return the name of the object
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter method for the name field.
	 * @param name the name of the object
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter method for the label field.
	 * @return the label of the object
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 *  Setter method for the label field.
	 * @param label the label of the object
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Getter method for the id field.
	 * @return the description of the object
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Setter method for the description field.
	 * @param description the description of the object
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter method for the id field.
	 * @return the weather of the object
	 */
	public WeatherAverageDTO getWeather() {
		return weather;
	}

	/**
	 * Setter method for the weather field.
	 * @param weather the weather of the object
	 */
	public void setWeather(WeatherAverageDTO weather) {
		this.weather = weather;
	}
	
}
