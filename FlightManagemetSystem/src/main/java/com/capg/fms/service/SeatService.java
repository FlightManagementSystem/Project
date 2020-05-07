package com.capg.fms.service;

import java.util.List;
import com.capg.fms.model.BookedSeats;

public interface SeatService
{
	public BookedSeats newSeat(BookedSeats seat);
	public BookedSeats getSeat(int seatnumber);
	public List<BookedSeats> getAllSeat(int seatnumber);
	
}
