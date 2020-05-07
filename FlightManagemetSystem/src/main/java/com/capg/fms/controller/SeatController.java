package com.capg.fms.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.service.SeatService;
import com.capg.fms.exceptions.SeatNotFoundException;
import com.capg.fms.model.BookedSeats;


@RestController
@RequestMapping("/bookedSeats")
 
public class SeatController 
{
	@Autowired
	SeatService seatService;
	
	/*
	 * This is a PostMethod(Http) is used to add the seat in the database.
	 * Method 	 : addSeat
	 * Type 	 : ResponseEntity<String>
	 * parameters: 
	 * Author 	 : Nishita Khanna
	 * Version   :
	 */
	
	@GetMapping("/addSeat")
	public ResponseEntity<String> addSeat(@Valid @RequestBody BookedSeats seat)
	{
		seatService.newSeat(seat);
		return new ResponseEntity <String>("Seat Added",HttpStatus.OK);
	}
	
	/*
	 * This is a GetMethod(Http) is used to get all the seat in the database.
	 * Method 	 : getAllSeat
	 * Type 	 : ResponseEntity<List<BookedSeats>
	 * parameters: -
	 * Author 	 : Nishita Khanna
	 * Version   :
	 */
	
	@GetMapping("/getAllSeat")
    public ResponseEntity<List<BookedSeats>> getAllSeat( @PathVariable int seatnumber) throws SeatNotFoundException
	{
			List<BookedSeats> list = seatService.getAllSeat(seatnumber);
			
			if(list == null)
				
				throw new SeatNotFoundException("Sorry there was no data in the database");
			
			return new ResponseEntity<List<BookedSeats>>(list,HttpStatus.OK);
	}
	
	/*
	 * This is a GetMethod(Http) is used to get the seat in the database.
	 * Method 	 : addSeat
	 * Type 	 : ResponseEntity<String>
	 * parameters: seatnumber
	 * Author 	 : Nishita Khanna
	 * Version   :
	 */
	
	@GetMapping("/getSeat/{seatnumber}")
	public ResponseEntity<BookedSeats> getSeat( @PathVariable int seatnumber) throws SeatNotFoundException 
	{
		BookedSeats list = seatService.getSeat(seatnumber);
		if(list == null)
			throw new SeatNotFoundException(seatnumber +""+ "Not Found in database");
		return new ResponseEntity<BookedSeats>(list,HttpStatus.OK);
	}
}
