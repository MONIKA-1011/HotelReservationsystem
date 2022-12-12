package com.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.hotelmanagementsystem.model.Booking;
import com.hotelmanagementsystem.service.BookingService;


@CrossOrigin(origins="http://localhost:8089")
@RestController
@RequestMapping("/api/booking")

public class BookingController {
	@Autowired
	private BookingService bookingService;

	public BookingController(BookingService bookingService) {
		super();
		this.bookingService = bookingService;
	}
	@PostMapping("/add")
	public ResponseEntity<Booking> addCustomer(@RequestBody Booking booking)
	{
		return new ResponseEntity<Booking>(bookingService.saveBooking(booking),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Booking> getCustomer()
	{
		return bookingService.getBooking();
	}
	@GetMapping("{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("bookingId") long bookingId)
	{
		return new ResponseEntity<Booking>(bookingService.getBookingById(bookingId),HttpStatus.OK);
	}
	
	@DeleteMapping("{bookingId}")
	public ResponseEntity<String> deleteBooking(@PathVariable("customerId") long bookingId)
	{
		bookingService.deleteBookingById(bookingId);
		return new ResponseEntity<String>("Booking deleted successfully",HttpStatus.OK);
	}
}