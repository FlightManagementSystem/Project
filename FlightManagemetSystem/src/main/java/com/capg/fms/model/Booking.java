package com.capgemini.app.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_psit")
public class Booking implements Serializable 
{	
	public Booking() 
	{
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="booking_id")
	int bookingId;
	@Column(name="user_id")
	int userId;
	@Column(name="booking_date")
	String Bookingdate;
	@Column(name="ticket_cost")
	int ticketCost;
	@Column(name="no_of_passengers")
	int noOfPassengers;

	public Booking(int bookingId, int userId, String bookingdate, int ticketCost,
			int noOfPassengers) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		Bookingdate = bookingdate;
		this.ticketCost = ticketCost;
		this.noOfPassengers = noOfPassengers;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBookingdate() {
		return Bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		Bookingdate = bookingdate;
	}

	public int getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", Bookingdate=" + Bookingdate
				+ ", passenger=" + ", ticketCost=" + ticketCost + ", noOfPassengers=" + noOfPassengers
				+ "]";
	}
	}