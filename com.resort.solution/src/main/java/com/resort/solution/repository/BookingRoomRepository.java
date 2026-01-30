package com.resort.solution.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resort.solution.entity.BookingRoom;

public interface BookingRoomRepository extends JpaRepository<BookingRoom, Integer> {
	List<BookingRoom> findByBooking_BookingId(Integer bookingId);
}
