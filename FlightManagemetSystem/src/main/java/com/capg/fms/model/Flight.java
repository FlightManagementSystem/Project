package com.capg.fms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Flights")
public class Flight {
	
	/**
	 * 
	 */

	@Id
	@Size(min = 5, max = 10)
	@Column(name="Flight_Number")
	private long flightNumber;
	@Column(name="Carrier_Name")
	private String carrierName;
	@Column(name="Seat_Capacity")
	private int seatCapacity;
	
	/*
	 * No Args Constructor for FlightModel
	 * All Args Constructor for FlightModel
	 */

	public Flight(long flightNumber, String carrierName, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}

	public Flight() {

	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", carrierName=" + carrierName + ", seatCapacity="
				+ seatCapacity + "]";
	}

}
