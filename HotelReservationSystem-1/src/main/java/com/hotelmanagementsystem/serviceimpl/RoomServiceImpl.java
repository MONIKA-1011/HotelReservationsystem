package com.hotelmanagementsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagementsystem.exception.ResourceNotFoundException;
import com.hotelmanagementsystem.model.Room;
import com.hotelmanagementsystem.repository.RoomRepository;
import com.hotelmanagementsystem.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	@Autowired
	private RoomRepository roomRepository;
	
	public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

	@Override
	public Room saveRoom(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

	@Override
	public List<Room> getRoom() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	@Override
	public Room getRoomById(long roomId) {
		// TODO Auto-generated method stub
		return roomRepository.findById(roomId).orElseThrow(()->new ResourceNotFoundException("Room","RoomId",roomId));
		
		

	}

	@Override
	public void deleteRoomById(long roomId) {
		// TODO Auto-generated method stub
		roomRepository.findById(roomId).orElseThrow(()->new ResourceNotFoundException("Room","RoomId",roomId));
		roomRepository.deleteById(roomId);
	
	}
}
