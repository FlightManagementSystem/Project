package com.capg.fms.service;

import com.capg.fms.dao.FlightDao;
import com.capg.fms.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService  {

    
	@Autowired
    private FlightDao flightDao;

	
	/*
	 * This method is used to add the flight from Flights Table.
	 * Method 	 : addFlight
	 * Type 	 : Flight
	 * parameters: flight
	 * Author 	 : Alok Singh Gaur
	 * Date 	 : 04/05/2020
	 * Version   : 1.0
	 */
    @Override
    public Flight addFlight(Flight flight) {
    	flightDao.addFlight(flight);
    	return flight;
    }

    
    /*
	 * This method is used to updateFlight the flight from Flights Table.
	 * Method 	 : updateFlight
	 * Type 	 : Flight
	 * parameters: flight
	 * Author 	 : Alok Singh Gaur
	 * Date 	 : 04/05/2020
	 * Version   : 1.0
	 */
    @Override
    public Flight updateFlight(Flight flight) {
        flightDao.updateFlight(flight);
        return flight;
    }

    
    /*
	 * This method is used to viewFlight the flight based on flightNumber from Flights Table.
	 * Method 	 : viewFlight
	 * Type 	 : Flight
	 * parameters: flightNumber
	 * Author 	 : Alok Singh Gaur
	 * Date 	 : 04/05/2020
	 * Version   : 1.0
	 */
    @Override
    public Flight viewFlight(int flightNumber){
        return flightDao.retrieveFlight(flightNumber);
    }

    
    /*
	 * This method is used to view all  the flight from Flights Table.
	 * Method 	 : ViewAllFlights
	 * Type 	 : Flight
	 * parameters: 
	 * Author 	 : Alok Singh Gaur
	 * Date 	 : 04/05/2020
	 * Version   : 1.0
	 */
    @Override
    public List<Flight> ViewAllFlights(){
        return flightDao.retrieveAllFlights();
    }

    
    /*
	 * This method is used to deleteFlight the flight from Flights Table.
	 * Method 	 : deleteFlight
	 * Type 	 : Boolean
	 * parameters: flightNumber
	 * Author 	 : Alok Singh Gaur
	 * Date 	 : 04/05/2020
	 * Version   : 1.0
	 */
    @Override
    public boolean deleteFlight(long flightNumber) {
         return flightDao.deleteFlight(flightNumber); 
    }
  }


