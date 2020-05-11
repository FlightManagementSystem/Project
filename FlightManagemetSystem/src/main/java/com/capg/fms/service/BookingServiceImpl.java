package com.capgemini.app.service;

import java.util.List;
//
import javax.transaction.Transactional;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.dao.BookingDao;
import com.capgemini.app.entity.Booking;

@Transactional
@Service
public class BookingServiceImpl implements BookingService
{

	@Autowired
	private BookingDao bookingDao;

	
	/*
	 * This method is used to add booking in the Booking Table.
	 * Method 	 : addBookingService
	 * Type 	 : Booking
	 * parameters: booking
	 * Author 	 : Shivam Gupta
	 * Date 	 : 8/05/2020
	 */
	@Override
	public Booking addBookingService(Booking booking) 
	{
		// TODO Auto-generated method stub
		bookingDao.addBooking(booking);
		return booking;
	}

	

	/*
	 * This method is used to read all booking from the Booking Table.
	 * Method 	 : viewAllBookings
	 * Type 	 : List<Booking>
	 * parameters: 
	 * Author 	 : Shivam Gupta
	 * Date 	 : 8/05/2020
	 */
	
	@Override
		public List<Booking> viewAllBookings() {
			// TODO Auto-generated method stub
			return bookingDao.viewAllBookings();
	}
	

	/*
	 * This method is used to read all booking from the Booking Table.
	 * Method 	 : cancelBookingService
	 * Type 	 : Booking
	 * parameters: bookingId
	 * Author 	 : Shivam Gupta
	 * Date 	 : 8/05/2020
	 */
	
	
	@Override
	public Booking cancelBookingService(int bookingId)
	{
		// TODO Auto-generated method stub
		return bookingDao.cancelBooking(bookingId);
	
	}



	/*
	 * This method is used to read  booking by bookingId from the Booking Table.
	 * Method 	 : viewbooking
	 * Type 	 : Booking
	 * parameters: bookingId
	 * Author 	 : Shivam Gupta
	 * Date 	 : 8/05/2020
	 */

	@Override
	public Booking viewBooking(int bookingId) {
		// TODO Auto-generated method stub
		return bookingDao.viewBooking(bookingId);	}

}
