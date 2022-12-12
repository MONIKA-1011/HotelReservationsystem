package com.hotelmanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="room_table")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="room_id")
	private long roomId;
	
	@Column(name="room_number")
	@NotEmpty
	@Size(min=2 ,max=4, message="roomNumber must be between 2- 4 digits")
	private String roomNumber;
	
	@Column(name="room_type")
	@NotEmpty
	@Size(min=4 , message="roomType must contain atleast 4 characters")
	private String roomType;
	
	@Column(name="room_price")
	@NotNull
	private int roomPrice;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Hotel_Id")
	private Hotel hotel;

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
public Room() {
		
	}

public Room(long roomId,
		@NotEmpty @Size(min = 2, max = 4, message = "roomNumber must be between 2- 4 digits") String roomNumber,
		@NotEmpty @Size(min = 4, message = "roomType must contain atleast 4 characters") String roomType,
		@NotNull int roomPrice, Hotel hotel) {
	super();
	this.roomId = roomId;
	this.roomNumber = roomNumber;
	this.roomType = roomType;
	this.roomPrice = roomPrice;
	this.hotel = hotel;
}
	
	
}
