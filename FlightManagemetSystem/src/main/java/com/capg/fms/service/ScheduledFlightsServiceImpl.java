package com.capg.fms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.dao.ScheduledFlightsDao;
import com.capg.fms.exceptions.ScheduleIdExistsException;
import com.capg.fms.exceptions.ScheduleIdNotFoundException;
import com.capg.fms.model.Schedule;
import com.capg.fms.model.ScheduledFlights;

@Service
@Transactional
public class ScheduledFlightsServiceImpl implements ScheduledFlightsService{
	
	@Autowired
	private ScheduledFlightsDao scheduledFlightsDao;

	/* Method:newcheduledFlights
	 * This method is used to add the scheduled flight in the ScheduledFlights table.
	 * Type:boolean
	 * Parameter:sflight
	 * Author Name:Mahima Mishra
	 */
	@Override
	public ScheduledFlights newScheduledFlights(ScheduledFlights sflight) {
		scheduledFlightsDao.addScheduledFlights(sflight);
		return sflight;
	}

	/* Method:getScheduledFlights
	 * This method is used to retrieve the scheduled flight from the Schedule, ScheduledFlights and Flight table.
	 * Type:List<Schedule>
	 * Parameters:source and destination
	 * Author Name:Mahima Mishra
	 */
	@Override
	public List<ScheduledFlights> getScheduledFlight(String source, String destination) {
		return scheduledFlightsDao.retrieveScheduledFlights(source, destination);
	}
	
	/* Method:getAllScheduledFlights
	 * This method is used to retrieve all scheduled flight from the ScheduledFlights table.
	 * Type:List<ScheduledFlights>
	 * Parameter:-
	 * Author Name:Mahima Mishra
	 */
	@Override
	public List<ScheduledFlights> getAllScheduledFlights() {
		return scheduledFlightsDao.retrieveAllScheduledFlights();
	}
	
	/* Method:getScheduledFlight
	 * This method is used to retrieve the scheduled flight from the ScheduledFlights table.
	 * Type:List<ScheduledFlights>
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 */
	@Override
	public ScheduledFlights getScheduledFlight(int serialNo) {
		return scheduledFlightsDao.retrieveScheduledFlight(serialNo);
	}
	
	/* Method:modifyScheduledFlights
	 * This method is used to update the scheduled flight in the ScheduledFlights table.
	 * Type:boolean
	 * Parameter:sflight
	 * Author Name:Mahima Mishra
	 */
	@Override
	public boolean modifyScheduledFlights(ScheduledFlights sflight) {
		return scheduledFlightsDao.updateScheduledFlights(sflight);
	}

	/* Method:deleteScheduledFlights
	 * This method is used to delete the scheduled flight in the ScheduledFlights table.
	 * Type:boolean
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 */
	@Override
	public boolean deleteScheduledFlights(int scheduleId) {
		return scheduledFlightsDao.deleteScheduledFlights(scheduleId);
	}
}
