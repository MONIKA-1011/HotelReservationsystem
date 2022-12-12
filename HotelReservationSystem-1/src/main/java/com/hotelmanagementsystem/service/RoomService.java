package com.hotelmanagementsystem.service;

import java.util.List;

import com.hotelmanagementsystem.model.Room;

public interface RoomService {
	Room saveRoom(Room room);
	List<Room> getRoom();
	Room getRoomById(long roomId);
	void deleteRoomById(long roomId);
}
