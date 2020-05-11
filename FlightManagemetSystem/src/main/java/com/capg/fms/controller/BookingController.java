package com.capgemini.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entity.Booking;
import com.capgemini.app.exception.BookingException;
import com.capgemini.app.exception.IdNotFoundException;
import com.capgemini.app.service.BookingService;


@RestController
@RequestMapping("/bookings")
public class BookingController {
	@Autowired
	private BookingService bookingservice;

	/*
	 * This method is used to add booking in the Booking Table.
	 * Method 	 : addBooking
	 * Type 	 : Booking
	 * parameters: Booking
	 * Author 	 : Shivam Gupta
	 * Date 	 : 8/05/2020
	 */
	@PostMapping("/addBooking")
	public ResponseEntity<Object> saveBook(@RequestBody Booking booking) {
		if (booking.getNoOfPassengers() > 5)
			throw new BookingException("No of Passengers should be less than 5");
		Booking book = bookingservice.addBookingService(booking);
		return new ResponseEntity<Object>("Booking got added.", HttpStatus.OK);
	}
	
	/*
	 * This method is used to read all booking from the Booking Table.
	 * Method 	 : viewAllBooking
	 * Type 	 : List<Booking
	 * parameters: 
	 * Author 	 : Shivam Gupta
	 * Date 	 : 8/05/2020
	 */
	
	@GetMapping("/viewAllBookings")
	public ResponseEntity<List<Booking>> viewAllBooking() {
		List<Booking> view = bookingservice.viewAllBookings();
		return new ResponseEntity<List<Booking>>(view, HttpStatus.OK);
	}


	/*
	 * This method is used to read booking from the Booking Table by bookingId.
	 * Method 	 : viewbooking
	 * Type 	 : Booking
	 * parameters: bookingId
	 * Author 	 : Shivam Gupta
	 * Date 	 : 8/05/2020
	 */
	// Get Particular Booking data
	@GetMapping("/viewBookingById/{id}")
	private Booking viewBooking(@PathVariable("id") int bookingId) {
		Booking booking = bookingservice.viewBooking(bookingId);
		if (booking == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return booking;
		}

	}


	/*
	 * This method is used to cancel the booking by bookingId from the Booking Table.
	 * Method 	 : cancelBooking
	 * Type 	 : Booking
	 * parameters: bookingId
	 * Author 	 : Shivam Gupta
	 * Date 	 : 8/05/2020
	 */
	@DeleteMapping("/cancelBooking/{id}")
	public ResponseEntity<String> cancelBooking(@PathVariable("id") int bookingId) {
		Booking status = bookingservice.cancelBookingService(bookingId);
		// throw exception if booking id is not present
		if (status == null)
			throw new BookingException("Booking ID not found.");
		return new ResponseEntity<String>("Booking deleted successfully", HttpStatus.OK);
	}
}