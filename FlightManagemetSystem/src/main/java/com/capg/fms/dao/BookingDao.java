package com.capgemini.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.app.entity.Booking;



@Repository
public interface BookingDao
{
	/**
	 * 
	 * @param bookingId
	 * @return
	 */
	public Booking cancelBooking(int bookingId);
	
	/**
	 * 
	 * @param bookingList
	 * @return 
	 */
	public  Booking addBooking(Booking bookingList);
	/**
	 * 
	 * @return
	 */
	public List<Booking> viewAllBookings() ;
	
	/**
	 * 
	 * @param bookingid
	 * @return
	 */
	public Booking viewBooking(int bookingid);
}