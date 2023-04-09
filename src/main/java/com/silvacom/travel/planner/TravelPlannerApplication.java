package com.silvacom.travel.planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TravelPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelPlannerApplication.class, args);
	}

}
