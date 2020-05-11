package com.capg.fms.dao;

import java.util.List;

import com.capg.fms.model.Flight;

public interface FlightDao {

	public Flight addFlight(Flight flight);
	public Flight updateFlight(Flight flight);
	public Flight retrieveFlight(long flightNumber);
	public List<Flight> retrieveAllFlights();
	public boolean deleteFlight(long flightNumber);
	
}



