package com.capg.fms.dao;

import java.util.List;
import com.capg.fms.model.*;

public interface SeatDao 
{

	public boolean addSeat(BookedSeats seat);
	public BookedSeats retrieveSeat(int seatnumber);
	public List<BookedSeats> retrieveAllSeat(int seatnumber);

}
