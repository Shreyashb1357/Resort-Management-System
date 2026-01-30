package com.resort.solution.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.solution.entity.BookingRoom;
import com.resort.solution.repository.BookingRoomRepository;
import com.resort.solution.service.BookingRoomService;

@Service
public class BookingRoomServiceImpl implements BookingRoomService {
	
	@Autowired
	private BookingRoomRepository bookingRoomRepo;

	@Override
	public BookingRoom addRoomToBooking(BookingRoom bookingRoom) {
		if(bookingRoom==null || bookingRoom.getBooking()==null || bookingRoom.getRoom()==null) {
			return null;
		}
		BookingRoom newRoomBook = bookingRoom;
		return bookingRoomRepo.save(newRoomBook);
	}

	@Override
	public boolean removeRoomFromBooking(Integer bookingRoomId) {
		Optional<BookingRoom> newRoomBook = bookingRoomRepo.findById(bookingRoomId);
		if(newRoomBook.isEmpty()) {
			return false;
		}
		bookingRoomRepo.deleteById(bookingRoomId);
		return true;
		
	}

	@Override
	public List<BookingRoom> getRoomsByBooking(Integer bookingId) {
		List<BookingRoom> allRooms = bookingRoomRepo.findByBooking_BookingId(bookingId);
		return allRooms;
	}

}
