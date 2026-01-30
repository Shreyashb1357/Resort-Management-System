package com.resort.solution.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.solution.entity.Resort;
import com.resort.solution.entity.Room;
import com.resort.solution.enums.RoomStatus;
import com.resort.solution.repository.RoomRepository;
import com.resort.solution.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepo;

	@Override
	public Room addRoom(Room room) {
		if (room == null || room.getResort() == null || room.getRoomType() == null) {
			return null;
		}
		return roomRepo.save(room);
	}

	@Override
	public Room updateRoom(Integer roomId, Room room) {
		Room existing = roomRepo.findById(roomId).orElse(null);
		if (existing == null || room == null) {
			return null;
		}

		if (room.getRoomNumber() != null) {
			existing.setRoomNumber(room.getRoomNumber());
		}
		if (room.getRoomType() != null) {
			existing.setRoomType(room.getRoomType());
		}
		if (room.getBasePrice() > 0) {
			existing.setBasePrice(room.getBasePrice());
		}
		if (room.getStatus() != null) {
			existing.setStatus(room.getStatus());
		}

		return roomRepo.save(existing);
	}

	@Override
	public boolean changeRoomStatus(Integer roomId, RoomStatus status) {
		Room room = roomRepo.findById(roomId).orElse(null);
		if (room == null || status == null) {
			return false;
		}
		room.setStatus(status);
		roomRepo.save(room);
		return true;
	}

	@Override
	public List<Room> getRoomsByResort(Resort resort) {
		if (resort == null) {
			return null;
		}
		return roomRepo.findByResort_ResortId(resort.getResortId());
	}

	@Override
	public List<Room> getAvailableRooms(RoomStatus status) {
		return roomRepo.findByStatus(status);
	}

}
