package com.capg.fms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.capg.fms.model.Flight;
import com.capg.fms.model.Schedule;
import com.capg.fms.model.ScheduledFlights;

@Repository
public class ScheduledFlightsDaoImpl implements ScheduledFlightsDao{

	@PersistenceContext
	EntityManager entityManager;
	
	/* Method:addScheduledFlights
	 * This method is used to add the scheduled flight in the ScheduledFlights table.
	 * Type:boolean
	 * Parameter:ScheduledFlights
	 * Author Name:Mahima Mishra
	 */
	@Override
	public ScheduledFlights addScheduledFlights(ScheduledFlights sflight) {
		entityManager.persist(sflight);
		return sflight;
	}
	
	/* Method:retrieveScheduledFlights
	 * This method is used to retrieve the scheduled flight from the Schedule, ScheduledFlights and Flight table.
	 * Type:List<Schedule>
	 * Parameters:source and destination
	 * Author Name:Mahima Mishra
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ScheduledFlights> retrieveScheduledFlights(String source, String destination) {
		Query query = entityManager.createQuery("select s.scheduleId,s.source,s.destination,s.arrivaltime,s.departuretime,f.flightNumber,f.carrierName,f.seatCapacity from Schedule s JOIN ScheduledFlights sf ON s.scheduleId=sf.scheduleId JOIN Flight f on sf.flightId=f.flightNumber where schedule.source= :source AND schedule.destination=:destination");
		return query.getResultList();
	}
	
	/* Method:retrieveAllScheduledFlights
	 * This method is used to retrieve all scheduled flight from the ScheduledFlights table.
	 * Type:List<ScheduledFlights>
	 * Parameter:-
	 * Author Name:Mahima Mishra
	 */

	@Override
	public List<ScheduledFlights> retrieveAllScheduledFlights() {	
		TypedQuery<ScheduledFlights> query = entityManager.createQuery("select s from ScheduledFlights s, Flight f,Schedule sc where s.flight = f and s.schedule=sc",ScheduledFlights.class);
		List<ScheduledFlights> flights = query.getResultList();
		return flights;
	}
	
	/* Method:retriveScheduledFlight
	 * This method is used to retrieve the scheduled flight from the ScheduledFlights table.
	 * Type:List<ScheduledFlights>
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 */
	@Override
	public ScheduledFlights retrieveScheduledFlight(int serialNo){
		return entityManager.find(ScheduledFlights.class, serialNo);
	}
	
	/* Method:updateScheduledFlights
	 * This method is used to update the scheduled flight in the ScheduledFlights table.
	 * Type:boolean
	 * Parameter:ScheduledFlights
	 * Author Name:Mahima Mishra
	 */
	@Override
	public boolean updateScheduledFlights(ScheduledFlights sflight) {
		entityManager.getTransaction().begin();
		entityManager.merge(sflight);
		entityManager.getTransaction().commit();
		return true;
	}
	
	/* Method:deleteScheduledFlights
	 * This method is used to delete the scheduled flight in the ScheduledFlights table.
	 * Type:boolean
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 */
	@Override
	public boolean deleteScheduledFlights(int serialNo) {
		ScheduledFlights sflight =entityManager.find(ScheduledFlights.class, serialNo);
		if(sflight !=null)
		{
			entityManager.remove(sflight);
			return true;
		}
		else 
		return false;
	}
}
