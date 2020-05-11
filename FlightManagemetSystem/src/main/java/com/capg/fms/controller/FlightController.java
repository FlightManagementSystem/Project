package com.capg.fms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.model.Flight;
import com.capg.fms.service.FlightService;
import com.capg.fms.service.FlightServiceImpl;

@RestController
@RequestMapping("/FlightManagemetSystem")
public class FlightController {

	@Autowired
	public FlightService fmsService;
	

	/*
	  * This is a GetMethod(Http) by is used to get  all the flight  from the database.
	  * Method 	 : viewAllFlight
	  * Type 	 : Flight
	  * parameters: 
	  * Author 	 : Alok Singh Gaur
	  * Date 	 : 20/04/2020
	  * Version  : 1.0
	  */
	@GetMapping("/flightts")
	public ResponseEntity<List<Flight>> viewAllFlight()
	{
		List<Flight> list =fmsService.ViewAllFlights();
		return new ResponseEntity<List<Flight>>(list,HttpStatus.OK);
	}
		
	
	 /*
	  * This is a GetMethod(Http) by flightNumber is used to get  the flight  from the database.
	  * Method 	 : viewFlight
	  * Type 	 : Flight
	  * parameters: flightNumber
	  * Author 	 : Alok Singh Gaur
	  * Date 	 : 20/04/2020
	  * Version   : 1.0
	  */
		@GetMapping(value="/flight/{flightNumber}")
		public Flight viewFlight(@PathVariable int flightNumber)  {
			return fmsService.viewFlight(flightNumber);
		}
		
		
		
		/*
		 * This is a PostMethod(Http) is used to add the entity in the database.
		 * Method 	 : addFlight
		 * Type 	 : Flight
		 * parameters: flight
		 * Author 	 : Alok Singh Gaur
		 * Date 	 : 20/04/2020
		 * Version   : 1.0
		 */
		@PostMapping( value="/flights")
		public Flight addFlight(@RequestBody Flight flight) {
			 return fmsService.addFlight(flight);
		}
		
		/*
		 * This is a DeleteMethod(Http) by "flightNumber" is used to delete the entity from the database.
		 * Method 	 :  deleteFlight
		 * Type 	 :  boolean
		 * parameters:  flightNumber
		 * Author 	 :  Alok Singh Gaur
		 * Date 	 :  20/04/2020
		 * Version   : 1.0
		 */

		@DeleteMapping("/flight/delete/{flightNumber}")
		public boolean deleteFlight(@PathVariable int flightNumber){
			return fmsService.deleteFlight(flightNumber);
		}
		
		/*
		 * This is a UpdateMethod(Http) by "flightNumber" is used to modify the entity from the database.
		 * Method 	 :  modifyFlight
		 * Type 	 :  Flight
		 * parameters:  flight
		 * Author 	 :  Alok Singh Gaur
		 * Date 	 :  20/04/2020
		 * Version   : 1.0
		 */
		
		@PutMapping(value="/flight/modify")
		public Flight modifyFlight(@RequestBody Flight flight) {
			return fmsService.updateFlight(flight);
		}
}
		
		
		
