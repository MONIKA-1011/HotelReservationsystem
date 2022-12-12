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

import com.hotelmanagementsystem.model.Hotel;
import com.hotelmanagementsystem.service.HotelService;

@CrossOrigin(origins="http://localhost:8089")
@RestController
@RequestMapping("/api/hotel")
public class HotelContoller {
	@Autowired
	private HotelService hotelService;

	public HotelContoller(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel)
	{
		return new ResponseEntity<Hotel>(hotelService.saveHotel(hotel),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Hotel> getHotel()
	{
		return hotelService.getHotel();
	}
	
	@GetMapping("{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("HotelId") long hotelId)
	{
		return new ResponseEntity<Hotel>(hotelService.getHotelById(hotelId),HttpStatus.OK);
	}
	
	@DeleteMapping("{hotelId}")
	public ResponseEntity<String> deleteHotel(@PathVariable("hotelId") long hotelId)
	{
		hotelService.deleteHotelById(hotelId);
		return new ResponseEntity<String>("Hotel deleted successfully",HttpStatus.OK);
	}

}
