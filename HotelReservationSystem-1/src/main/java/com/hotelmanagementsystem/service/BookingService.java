package com.hotelmanagementsystem.service;

import java.util.List;

import com.hotelmanagementsystem.model.Booking;

public interface BookingService {
	Booking saveBooking(Booking booking);
	List<Booking> getBooking();
	Booking getBookingById(long bookingId);
	void deleteBookingById(long bookingId);
}
