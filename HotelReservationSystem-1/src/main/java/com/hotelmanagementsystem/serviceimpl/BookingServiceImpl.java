package com.hotelmanagementsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagementsystem.exception.ResourceNotFoundException;
import com.hotelmanagementsystem.model.Booking;
import com.hotelmanagementsystem.repository.BookingRepository;
import com.hotelmanagementsystem.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{
	@Autowired
	private BookingRepository bookingRepository;
	
	
	public BookingServiceImpl(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}

	@Override
	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getBooking() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	@Override
	public Booking getBookingById(long bookingId) {
		// TODO Auto-generated method stub
		return bookingRepository.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking","BookingId",bookingId));
	
	}

	@Override
	public void deleteBookingById(long bookingId) {
		// TODO Auto-generated method stub
		bookingRepository.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking","BookingId",bookingId)); 
		bookingRepository.deleteById(bookingId);
	}

}
