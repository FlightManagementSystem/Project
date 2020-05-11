package com.capg.fms.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.capg.fms.model.Flight;

@Repository
public class FlightDaoImpl implements FlightDao {

	@PersistenceContext
	EntityManager entityManager;	
	
	
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
	public Flight  addFlight(Flight flight) {	
		entityManager.persist(flight);
		return flight;	
	}

	
	/*
	 * This method is used to modify the flight from Flights Table.
	 * Method 	 : updateFlight
	 * Type 	 : Flight
	 * parameters: flight
	 * Author 	 : Alok Singh Gaur
	 * Date 	 : 04/05/2020
	 * Version   : 1.0
	 */
	
	@Override
	public Flight updateFlight(Flight flight) {
		entityManager.getTransaction().begin();
		entityManager.merge(flight);
		entityManager.getTransaction().commit();
		return flight;
	}

	
	/*
	 * This method is used to fetch the flight based on corresponding flightId from Flights Table.
	 * Method 	 : retrieveFlight
	 * Type 	 : Flight
	 * parameters: retrieveFlight
	 * Author 	 : Alok Singh Gaur
	 * Date 	 : 04/05/2020
	 * Version   : 1.0
	 */
	@Override
	public Flight retrieveFlight(long FlightNumber) {
		return entityManager.find(Flight.class, FlightNumber);
	}

	
	/*
	 * This method is used to fetch all the flight from Flights Table.
	 * Method 	 : retrieveAllFlights
	 * Type 	 : Flight
	 * parameters: 
	 * Author 	 : Alok Singh Gaur
	 * Date 	 : 04/05/2020
	 * Version   : 1.0
	 */
	@Override
	public List<Flight> retrieveAllFlights() {
		String query = "select f from Flight f";
		TypedQuery<Flight> fs = entityManager.createQuery(query, Flight.class);
		return fs.getResultList();	
	}

	
	/*
	 * This method is used to delete  the flight from Flights Table.
	 * Method 	 : deleteFlight
	 * Type 	 : boolean
	 * parameters: flightNumber
	 * Author 	 : Alok Singh Gaur
	 * Date 	 : 04/05/2020
	 * Version   : 1.0
	 */
	@Override
	public boolean deleteFlight(long flightNumber) {
		Flight flight = entityManager.find(Flight.class, flightNumber);
		if(flight != null)
		{
			entityManager.remove(flight);
			return true;
		}
		else {
		return false;	
		}
	}
}
