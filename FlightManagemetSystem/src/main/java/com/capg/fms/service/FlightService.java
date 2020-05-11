package com.capg.fms.service;


import java.util.List;
import com.capg.fms.model.Flight;

public interface FlightService {


	
	public Flight addFlight(Flight flight);
	public Flight updateFlight(Flight flight);
	public boolean deleteFlight(long flightNumber);
    public List<Flight> ViewAllFlights();
    public Flight viewFlight(int flightNumber);
   
    
}

   
