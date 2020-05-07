package com.capg.fms.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.fms.dao.SeatDao;
import com.capg.fms.model.BookedSeats;

@Service
@Transactional
public class SeatServiceImpl implements SeatService {
	@Autowired
	private SeatDao seatDao;

	/*
	 * This method is used to add newSeat into the BookedSeats Table.
	 *  Method : newSeat
	 *  Type : BookedSeats 
	 *  parameters: seat 
	 *  Author : Nishita Khanna 
	 *  Version :
	 */

	@Override
	public BookedSeats newSeat(BookedSeats seat) {
		seatDao.addSeat(seat);
		return seat;
	}

	/*
	 * This method is used to getSeat into the BookedSeats Table.
	 *  Method : getSeat
	 * Type : BookedSeats 
	 * parameters: seatnumber 
	 * Author : Nishita Khanna 
	 * Version :
	 */

	@Override
	public BookedSeats getSeat(int seatnumber) {
		return seatDao.retrieveSeat(seatnumber);

	}

	/*
	 * This method is used to getAllSeat into the BookedSeats Table. Method :
	 * getAllSeat
	 *  Type : BookedSeats 
	 *  parameters: seatnumber 
	 *  Author : Nishita Khanna
	 * Version :
	 */

	@Override
	public List<BookedSeats> getAllSeat(int seatnumber) {
		return seatDao.retrieveAllSeat(seatnumber);

	}
}


	@Override
	public List<BookedSeats> getAllSeat() {
		return seatdao.getAllSeat();
	
	}
}
