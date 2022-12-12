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

import com.hotelmanagementsystem.model.Room;
import com.hotelmanagementsystem.service.RoomService;

@CrossOrigin(origins="http://localhost:4200")
@RestController //is controller which provides different end points to access the services 
@RequestMapping("/api/room")
public class RoomController {
	@Autowired
	private RoomService roomService;

	public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Room> addRoom(@RequestBody Room room)
	{
		return new ResponseEntity<Room>(roomService.saveRoom(room),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Room> getRoom()
	{
		return roomService.getRoom();
	}
	
	@GetMapping("{roomId}")
	public ResponseEntity<Room> getRoomById(@PathVariable("roomId") long roomId)
	{
		return new ResponseEntity<Room>(roomService.getRoomById(roomId),HttpStatus.OK);
	}
	
	@DeleteMapping("{customerId}")
	public ResponseEntity<String> deleteRoom(@PathVariable("roomId") long roomId)
	{
		roomService.deleteRoomById(roomId);
		return new ResponseEntity<String>("Room Deleted Successfully",HttpStatus.OK);
	}
}
