package com.silvacom.tarvel.planner.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a simple POJO with date and time wise weather info fields.
 * @author hdholariya
 *
 */
public class WeatherMapTimeDTO {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("dt_txt")
	private LocalDateTime dt;

	/**
	 * Instance of WeatherMapTimeMainDTO
	 */
	private WeatherMapTimeMainDTO main;

	/**
	 * Getter method for the dt field.
	 * @return Time of data calculation
	 */
	public LocalDateTime getDt() {
		return dt;
	}

	/**
	 * Setter method for the dt field.
	 * @param dt Time of data calculation
	 */
	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}

	/**
	 * Getter method for the main field.
	 * @return Group of weather parameters
	 */
	public WeatherMapTimeMainDTO getMain() {
		return main;
	}

	/**
	 * Setter method for the main field.
	 * @param main Group of weather parameters
	 */
	public void setMain(WeatherMapTimeMainDTO main) {
		this.main = main;
	}

	/**
	 * Getter method for the daily field.
	 * @return true if time of data calculation is between 6 to 18.
	 */
	@JsonIgnore
	public Boolean isDaily() {
		return (this.dt.getHour() >= 6 && this.dt.getHour() < 18);
	}

}
