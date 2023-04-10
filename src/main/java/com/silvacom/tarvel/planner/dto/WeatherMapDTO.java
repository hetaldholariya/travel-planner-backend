package com.silvacom.tarvel.planner.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * This class represents a simple POJO with weather info fields.
 * @author hdholariya
 *
 */
@JacksonXmlRootElement(localName = "weather")
public class WeatherMapDTO implements Serializable {

	private static final long serialVersionUID = 1253320017739887653L;

	private String cod;

	private BigDecimal message;

	private Integer cnt;

	@JacksonXmlProperty(localName = "list")
	@JacksonXmlElementWrapper(localName = "list", useWrapping = true)
	private List<WeatherMapTimeDTO> list;

	/**
	 * Getter method for the cod field.
	 * @return the cod Internal parameter
	 */
	public String getCod() {
		return cod;
	}

	/**
	 * Setter method for the cod field.
	 * @param cod Internal parameter
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}

	/**
	 * Getter method for the message field.
	 * @return message The Internal parameter
	 */
	public BigDecimal getMessage() {
		return message;
	}

	/**
	 * Setter method for the message field.
	 * @param message The Internal parameter
	 */
	public void setMessage(BigDecimal message) {
		this.message = message;
	}

	/**
	 * Getter method for the cnt field.
	 * @return The count of result data
	 */
	public Integer getCnt() {
		return cnt;
	}

	/**
	 * Setter method for the cnt field.
	 * @param cnt The count of result data
	 */
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	/**
	 * Getter method for the list field
	 * @return The list of WeatherMapTimeDTO objects
	 */
	public List<WeatherMapTimeDTO> getList() {
		return list;
	}

	/**
	 * Setter method for the list field
	 * @param The list of WeatherMapTimeDTO objects
	 */
	public void setList(List<WeatherMapTimeDTO> list) {
		this.list = list;
	}

}
