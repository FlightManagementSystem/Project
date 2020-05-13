package com.capg.fms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.dao.ScheduleDao;
import com.capg.fms.exceptions.ScheduleIdExistsException;
import com.capg.fms.exceptions.ScheduleIdNotFoundException;
import com.capg.fms.model.Schedule;


@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleDao scheduleDao;

	/* Method:newSchedule
	 * This method is used to add the schedule in the Schedule table.
	 * Type:boolean
	 * Parameter:Schedule
	 * Author Name:Mahima Mishra
	 */
	@Override
	public Schedule newSchedule(Schedule schedule){
		scheduleDao.addSchedule(schedule);
		return schedule;
	}

	/* Method:getSchedule
	 * This method is used to retrieve the schedule from the Schedule table.
	 * Type:List<Schedule>
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 */
	@Override
	public Schedule getSchedule(int scheduleId){
		return scheduleDao.retrieveSchedule(scheduleId);
			
	}

	/* Method:getAllSchedule
	 * This method is used to retrieve all schedules from the Schedule table.
	 * Type:List<Schedule>
	 * Parameter:-
	 * Author Name:Mahima Mishra
	 */
	@Override
	public List<Schedule> getAllSchedule() {
		return scheduleDao.retrieveAllSchedule();
	}

	/* Method:modifySchedule
	 * This method is used to update the schedule in the Schedule table.
	 * Type:boolean
	 * Parameter:Schedule
	 * Author Name:Mahima Mishra
	 */	
	@Override
	public boolean modifySchedule(Schedule schedule) {
		scheduleDao.updateSchedule(schedule);
		return true;
	}

	/* Method:deleteSchedule
	 * This method is used to delete the schedule in the Schedule table.
	 * Type:boolean
	 * Parameter:scheduleId
	 * Author Name:Mahima Mishra
	 */
	@Override
	public boolean deleteSchedule(int serialNo) {
		return scheduleDao.deleteSchedule(serialNo);
	}

	
	
	

}
