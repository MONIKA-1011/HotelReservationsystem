package com.hotelmanagementsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagementsystem.exception.ResourceNotFoundException;
import com.hotelmanagementsystem.model.Hotel;
import com.hotelmanagementsystem.repository.HotelRepository;
import com.hotelmanagementsystem.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	private HotelRepository hotelRepository;
	
	public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getHotel() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(long hotelId) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel","HotelId",hotelId));
	
	}

	@Override
	public void deleteHotelById(long hotelId) {
		// TODO Auto-generated method stub
		hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel","HotelId",hotelId)); 
		hotelRepository.deleteById(hotelId);

	}

}
