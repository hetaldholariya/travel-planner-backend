package com.silvacom.tarvel.planner.dto;

import java.math.BigDecimal;

/**
 * This class represents a simple POJO with group of weather info fields.
 * @author hdholariya
 *
 */
public class WeatherMapTimeMainDTO {

	private BigDecimal temp;

	private BigDecimal temp_min;

	private BigDecimal temp_max;

	private BigDecimal pressure;

	private BigDecimal sea_level;

	private BigDecimal grnd_level;

	private BigDecimal humidity;

	private BigDecimal temp_kf;

	/**
	 * Getter method for the temp field.
	 * @return The Temperature
	 */
	public BigDecimal getTemp() {
		return temp;
	}

	/**
	 * Setter method for the temp field.
	 * @param temp The Temperature
	 */
	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	/**
	 * Getter method for the temp_min field.
	 * @return Minimum temperature at the moment
	 */
	public BigDecimal getTemp_min() {
		return temp_min;
	}

	/**
	 * Setter method for the temp_min field.
	 * @param temp_min Minimum temperature at the moment
	 */
	public void setTemp_min(BigDecimal temp_min) {
		this.temp_min = temp_min;
	}

	/**
	 * Getter method for the temp_max field.
	 * @return Maximum temperature at the moment
	 */
	public BigDecimal getTemp_max() {
		return temp_max;
	}

	/**
	 * Setter method for the temp_max field.
	 * @param temp_max Maximum temperature at the moment
	 */
	public void setTemp_max(BigDecimal temp_max) {
		this.temp_max = temp_max;
	}

	/**
	 * Getter method for the pressure field.
	 * @return Pressure value
	 */
	public BigDecimal getPressure() {
		return pressure;
	}

	/**
	 * Setter method for the pressure field.
	 * @param pressure Pressure value
	 */
	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	/**
	 * Getter method for the sea_level field.
	 * @return The atmospheric pressure on the sea level
	 */
	public BigDecimal getSea_level() {
		return sea_level;
	}

	/**
	 * Setter method for the sea_level field.
	 * @param sea_level The atmospheric pressure on the sea level
	 */
	public void setSea_level(BigDecimal sea_level) {
		this.sea_level = sea_level;
	}

	/**
	 * Getter method for the grnd_level field.
	 * @return The atmospheric pressure on the ground level
	 */
	public BigDecimal getGrnd_level() {
		return grnd_level;
	}

	/**
	 * Setter method for the grnd_level field.
	 * @param grnd_level The atmospheric pressure on the ground level
	 */
	public void setGrnd_level(BigDecimal grnd_level) {
		this.grnd_level = grnd_level;
	}

	/**
	 * Getter method for the humidity field.
	 * @return The humidity, %
	 */
	public BigDecimal getHumidity() {
		return humidity;
	}

	/**
	 * Setter method for the humidity field.
	 * @param humidity The humidity, %

	 */
	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	/**
	 * Getter method for the temp_kf field.
	 * @return
	 */
	public BigDecimal getTemp_kf() {
		return temp_kf;
	}

	/**
	 * Setter method for the temp_kf field.
	 * @param temp_kf
	 */
	public void setTemp_kf(BigDecimal temp_kf) {
		this.temp_kf = temp_kf;
	}

}
