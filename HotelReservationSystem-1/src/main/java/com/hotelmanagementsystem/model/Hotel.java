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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="hotel_table")
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hotel_id")
	private long id;
	
	@Column(name="hotel_name")
	@NotEmpty
	@Size(min=3 , message="hotelName must contain atleast 3 characters")
	private String hotelName;
	
	@OneToMany(mappedBy="hotel")
	@JsonIgnore
	private List<Room> room;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bookingId")
	private Booking booking;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
public Hotel() {
		
	}

public Hotel(long id,
		@NotEmpty @Size(min = 3, message = "hotelName must contain atleast 3 characters") String hotelName,
		Booking booking) {
	super();
	this.id = id;
	this.hotelName = hotelName;
	this.booking = booking;
}





}
