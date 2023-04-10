package com.silvacom.tarvel.planner.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class represents a simple POJO with aggregate weather info fields.
 * @author hdholariya
 *
 */
public class WeatherAverageDTO implements Serializable {

	private static final long serialVersionUID = 5763148931413501367L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;

	private BigDecimal daily;

	private BigDecimal nightly;

	private BigDecimal pressure;

	@JsonIgnore
	private BigDecimal totalDaily;

	@JsonIgnore
	private Integer quantDaily;

	@JsonIgnore
	private BigDecimal totalNightly;

	@JsonIgnore
	private Integer quantNightly;

	@JsonIgnore
	private BigDecimal totalPressure;

	@JsonIgnore
	private Integer quantPressure;

	/**
	 * Constructor for creating a new WeatherAverageDTO object
	 * 
	 */
	public WeatherAverageDTO() {
		this.totalDaily = BigDecimal.ZERO;
		this.totalNightly = BigDecimal.ZERO;
		this.totalPressure = BigDecimal.ZERO;
		this.quantDaily = 0;
		this.quantNightly = 0;
		this.quantPressure = 0;
	}

	/**
	 * Constructor for creating a new WeatherAverageDTO object
	 * @param date the date of the object
	 * @param daily the average day temperature of the object
	 * @param nightly the average night temperature of the object
	 * @param pressure the average day pressure of the object
	 * @param totalDaily the total day temperature of the object
	 * @param quantDaily the hours count for the day of the object
	 * @param totalNightly the total night hours of the object
	 * @param quantNightly the hours count for the night of the object
	 * @param totalPressure the total day pressure  of the object
	 * @param quantPressure the hours count for the day pressure of the object
	 */
	public WeatherAverageDTO(LocalDate date, BigDecimal daily, BigDecimal nightly, BigDecimal pressure,
			BigDecimal totalDaily, Integer quantDaily, BigDecimal totalNightly, Integer quantNightly,
			BigDecimal totalPressure, Integer quantPressure) {
		this.date = date;
		this.daily = daily;
		this.nightly = nightly;
		this.pressure = pressure;
		this.totalDaily = totalDaily;
		this.quantDaily = quantDaily;
		this.totalNightly = totalNightly;
		this.quantNightly = quantNightly;
		this.totalPressure = totalPressure;
		this.quantPressure = quantPressure;
	}

	/**
	 * Calculate totals and counts of temperatures and pressure for the night and day.
	 * @param map the object of the WeatherMapTimeDTO
	 */
	public void plusMap(WeatherMapTimeDTO map) {
		if (map.isDaily()) {
			this.totalDaily = this.totalDaily.add(map.getMain().getTemp());
			this.quantDaily++;
		} else {
			this.totalNightly = this.totalNightly.add(map.getMain().getTemp());
			this.quantNightly++;
		}
		this.totalPressure = this.totalPressure.add(map.getMain().getTemp());
		this.quantPressure++;
	}

	/**
	 * Calculate average for daily, nightly and pressure.
	 */
	public void totalize() {
		this.daily = (this.quantDaily > 0)
				? this.totalDaily.divide(new BigDecimal(this.quantDaily.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.nightly = (this.quantNightly > 0)
				? this.totalNightly.divide(new BigDecimal(this.quantNightly.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.pressure = (this.quantPressure > 0)
				? this.totalPressure.divide(new BigDecimal(this.quantPressure.toString()), 2, RoundingMode.HALF_UP)
				: null;
	}

	/**
	 * Getter method for the date field.
	 * @return the date of the object
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Setter method for the date field.
	 * @param date the date of the object
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Getter method for the daily field.
	 * @return the daily of the object
	 */
	public BigDecimal getDaily() {
		return daily;
	}

	/**
	 * Setter method for the daily field.
	 * @param daily the daily of the object
	 */
	public void setDaily(BigDecimal daily) {
		this.daily = daily;
	}

	/**
	 * Getter method for the nightly field.
	 * @return the nightly of the object
	 */
	public BigDecimal getNightly() {
		return nightly;
	}

	/**
	 * Setter method for the nightly field.
	 * @param nightly the date of the object
	 */
	public void setNightly(BigDecimal nightly) {
		this.nightly = nightly;
	}

	/**
	 * Getter method for the pressure field.
	 * @return the pressure of the object
	 */
	public BigDecimal getPressure() {
		return pressure;
	}

	/**
	 * Setter method for the pressure field.
	 * @param pressure the pressure of the object
	 */
	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	/**
	 * Getter method for the total daily temperature field.
	 * @return the total daily temperature of the object
	 */
	public BigDecimal getTotalDaily() {
		return totalDaily;
	}

	/**
	 * Setter method for the total daily temperature field.
	 * @param totalDaily the total daily temperature of the object
	 */
	public void setTotalDaily(BigDecimal totalDaily) {
		this.totalDaily = totalDaily;
	}

	/**
	 * Getter method for the total day hours count field.
	 * @return the total day hours count of the object.
	 */
	public Integer getQuantDaily() {
		return quantDaily;
	}

	/**
	 * Setter method for the total day hours count field.
	 * @param quantDaily the total day hours count of the object.
	 */
	public void setQuantDaily(Integer quantDaily) {
		this.quantDaily = quantDaily;
	}

	/**
	 * Getter method for the total night hours count field.
	 * @return the total night hours count of the object.
	 */
	public BigDecimal getTotalNightly() {
		return totalNightly;
	}

	/**
	 * Setter method for the total night temperature field.
	 * @param totalNightly the total night temperature of the object
	 */
	public void setTotalNightly(BigDecimal totalNightly) {
		this.totalNightly = totalNightly;
	}

	/**
	 * Getter method for the total night hours count field.
	 * @return the total night temperature of the object
	 */
	public Integer getQuantNightly() {
		return quantNightly;
	}

	/**
	 * Setter method for the total night hours count field.
	 * @param quantNightly the date of the object
	 */ 
	public void setQuantNightly(Integer quantNightly) {
		this.quantNightly = quantNightly;
	}

	/**
	 * Getter method for the total pressure field.
	 * @return the total day pressure of the object.
	 */
	public BigDecimal getTotalPressure() {
		return totalPressure;
	}

	/**
	 * Setter method for the total pressure field.
	 * @param totalPressure total day pressure of the object.
	 */
	public void setTotalPressure(BigDecimal totalPressure) {
		this.totalPressure = totalPressure;
	}

	/**
	 * Getter method for the total pressure hours count field.
	 * @return the pressure hours count
	 */
	public Integer getQuantPressure() {
		return quantPressure;
	}

	/**
	 *  Setter method for the total pressure field.
	 * @param quantPressure the pressure hours count
	 */
	public void setQuantPressure(Integer quantPressure) {
		this.quantPressure = quantPressure;
	}

}
