package com.silvacom.travel.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * This class represents a simple POJO with group of weather info fields.
 * @author hdholariya
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TravelPlannerApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);
	}

}
