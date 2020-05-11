package com.capgemini.app.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.Booking;



@Repository
public class BookingDaoImpl implements BookingDao{
////
	@PersistenceContext
	EntityManager entityManager;
	
	/*
	 * This method is used to add booking in the Booking Table.
	 * Method 	 : addBooking
	 * Type 	 : Booking
	 * parameters: booking
	 * Author 	 : Shivam Gupta
	 * Date 	 : 8/05/2020
	 */
	
	@Override
	public Booking addBooking(Booking bookingList) {
		Booking booking=entityManager.merge(bookingList);
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
		String Qstr = "SELECT booking FROM Booking booking";
		TypedQuery<Booking> query = entityManager.createQuery(Qstr, Booking.class);
		return query.getResultList();
}


	/*
	 * This method is used to read all booking from the Booking Table.
	 * Method 	 : cancelBooking
	 * Type 	 : Booking
	 * parameters: bookingId
	 * Author 	 : Shivam Gupta
	 * Date 	 : 8/05/2020
	 */

	@Override
	public Booking cancelBooking(int bookingId) {
		// TODO Auto-generated method stub
		Booking cancelbooking = entityManager.find(Booking.class, bookingId);
		if(cancelbooking!=null)
			{
			entityManager.remove(cancelbooking);
			}
		return cancelbooking;
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
		Booking bookingList=entityManager.find(Booking.class,bookingId);
		return bookingList;
		
	}
}
