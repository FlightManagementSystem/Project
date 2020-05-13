package com.capg.fms.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.exceptions.ScheduleIdExistsException;
import com.capg.fms.exceptions.ScheduleIdNotFoundException;
import com.capg.fms.model.Schedule;
import com.capg.fms.model.ScheduledFlights;
import com.capg.fms.service.ScheduledFlightsService;

@RestController
@RequestMapping("/fms")
public class ScheduledFlightsController {
	@Autowired
	private ScheduledFlightsService scheduledFlightsService;
	
	/* Method 	  : getScheduledFlightById
	 * Description: This is a GetMethod(Http) by "scheduleId" is used to get the scheduled flight from the database.
	 * Type 	  : ResponseEntity<List<ScheduledFlights>>
	 * Parameters : scheduleId
	 * Author 	  : Mahima Mishra
	 */
	@GetMapping("/getScheduledFlightById/{serialNo}")
	public ScheduledFlights getScheduledFlightById(@PathVariable int serialNo){
		return scheduledFlightsService.getScheduledFlight(serialNo);
	}
	//
	/* Method 	  : getAllScheduledFlights
	 * Description: This is a GetMethod(Http) is used to get all scheduled flights from the database.
	 * Type 	  : ResponseEntity<List<ScheduledFlights>>
	 * Parameters : -
	 * Author 	  : Mahima Mishra
	 */
	@GetMapping("/getAllScheduledFlight")
	public List<ScheduledFlights> getAllScheduledFlights(){
		return scheduledFlightsService.getAllScheduledFlights();
	}
	
	/* Method 	  : getFlightSchedule
	 * Description: This is a GetMethod(Http) by "source" and "destination" is used to get all scheduled flights from the database.
	 * Type 	  : ResponseEntity<List<Schedule>>
	 * Parameters : source and destination
	 * Author 	  : Mahima Mishra
	 */
	@GetMapping("/getFlightSchedule/{source}/{destination}")
	public List<ScheduledFlights> getFlightSchedule(@PathVariable String source,@PathVariable String destination) {
		return scheduledFlightsService.getScheduledFlight(source, destination);
	}
	
	/* Method 	  : addScheduledFlight
	 * Description: This is a PostMethod(Http) is used to add the scheduled flight in the database.
	 * Type 	  : ResponseEntity<String>
	 * Parameters : Schedule(Class)
	 * Author 	  : Mahima Mishra
	 */
	@PostMapping("/addScheduledFlight")
	public ScheduledFlights addScheduledFlight(@RequestBody ScheduledFlights sflight){
		return scheduledFlightsService.newScheduledFlights(sflight);
	}
	
	/* Method 	  : modifyScheduledFlight
	 * Description: This is a PutMethod(Http) is used to update the scheduled flight in the database.
	 * Type 	  : ResponseEntity<String>
	 * Parameters : ScheduledFlights(Class)
	 * Author 	  : Mahima Mishra
	 */
	@PutMapping("/modifySchdeuledFlight")
	public String modifyScheduledFlight(@RequestBody ScheduledFlights sflight) {
		scheduledFlightsService.modifyScheduledFlights(sflight);
		return "Flight Schedule modified successfully";
	}
	
	/* Method 	  : deleteScheduledFlight
	 * Description: This is a DeleteMethod(Http) by "scheduleId" is used to delete the scheduled flight in the database.
	 * Type 	  : ResponseEntity<String>
	 * Parameters : scheduleId
	 * Author 	  : Mahima Mishra
	 */
	@DeleteMapping("/deleteScheduledFlight/{serialNo}")
	public String deleteScheduledFlight(@PathVariable int serialNo) {
		scheduledFlightsService.deleteScheduledFlights(serialNo);
		return "Flight Schedule with schedule Id:"+serialNo+"deleted successfully";
	}
	
	

}
