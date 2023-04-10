package com.silvacom.travel.planner.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * This class Indicates that this is a Spring service bean.
 * @author hdholariya
 *
 */
@Service
public class ForcastDateService {
	
    /**
     * Generate next future 3 dates
     * @return The future 3 dates
     */
    public List<LocalDate> getDates() {
    	List<LocalDate> dates= List.of(
    			LocalDate.now().plusDays(1),
    			LocalDate.now().plusDays(2),
    			LocalDate.now().plusDays(3)
    			);
        return dates;
    }
    
}
