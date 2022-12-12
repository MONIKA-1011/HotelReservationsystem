package com.hotelmanagementsystem.service;

import java.util.List;

import com.hotelmanagementsystem.model.Hotel;

public interface HotelService {
	Hotel saveHotel(Hotel hotel);
	List<Hotel> getHotel();
	Hotel getHotelById(long hotelId);
	void deleteHotelById(long hotelId);
}
