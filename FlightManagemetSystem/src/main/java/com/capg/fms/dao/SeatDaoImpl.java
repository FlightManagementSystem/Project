package com.capg.fms.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.capg.fms.model.BookedSeats;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;

@Repository
public abstract class SeatDaoImpl implements SeatDao
{
	@PersistenceContext
	EntityManager entityManager;
	
	/*
	 * This method is used to add Seats into the BookedSeats Table.
	 * Method 	 : addSeat
	 * Type 	 : Boolean
	 * parameters: seat
	 * Author 	 : Nishita Khanna
	 * Version 1.0
	 */
	
	@Override
	public boolean addSeat(BookedSeats seat) {
		entityManager.persist(seat);
		return true;
	}
	
	/*
	 * This method is used to add Seats into the BookedSeats Table.
	 * Method 	 : retrieveSeat
	 * Type 	 : BookedSeats
	 * parameters: seatnumber
	 * Author 	 : Nishita Khanna
	 * Version 1.0
	 */
	
	@Override
	public BookedSeats retrieveSeat(int seatnumber) {
		return entityManager.find(BookedSeats.class, seatnumber);
	}
	/*
	 * This method is used to add Seats into the BookedSeats Table.
	 * Method 	 : retrieveAllSeat
	 * Type 	 : BookedSeats
	 * parameters: seatnumber
	 * Author 	 : Nishita Khanna
	 * Version 1.0
	 */
	
	@Override
	public List<BookedSeats> retrieveAllSeat(int seatnumber) {
		String query = "select seats where booking id=" + seatnumber;
		TypedQuery<BookedSeats> bs = entityManager.createQuery(query, BookedSeats.class);
		return bs.getResultList();
		
	}
}

