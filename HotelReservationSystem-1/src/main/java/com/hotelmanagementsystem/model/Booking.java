package com.hotelmanagementsystem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="booking_table")
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_id")
	private long bookingId;
	
	@Column(name="hotel_name")
	private String hotelName;
		
	@Column(name="room_id")
	private long roomId;
	
	@Column(name="room_type")
	private String roomType;
	
	@Column(name="room_number")
	private String roomNumber;
	
	@Column(name="room_price")
	private int roomPrice;	

	@OneToMany(mappedBy="booking")
	@JsonIgnore
	private List<Hotel> hotel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	
public Booking() {
		
	}


public Booking(long bookingId, String hotelName, long roomId, String roomType, String roomNumber, int roomPrice,
		Customer customer) {
	super();
	this.bookingId = bookingId;
	this.hotelName = hotelName;
	this.roomId = roomId;
	this.roomType = roomType;
	this.roomNumber = roomNumber;
	this.roomPrice = roomPrice;
	this.customer = customer;
}


}
