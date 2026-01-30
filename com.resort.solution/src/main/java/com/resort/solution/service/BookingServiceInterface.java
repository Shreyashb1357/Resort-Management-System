package com.resort.solution.service;

import java.util.List;

import com.resort.solution.entity.Booking;
import com.resort.solution.entity.Resort;
import com.resort.solution.entity.User;
import com.resort.solution.enums.BookingStatus;

public interface BookingServiceInterface {
	Booking createBooking(Booking booking);
	boolean confirmBooking(Integer bookingId , BookingStatus status);
	boolean cancelBooking(Integer bookingId, BookingStatus status);
	boolean completeBooking(Integer bookingId, BookingStatus status);
	Booking getBookingById(Integer bookingId);
	List<Booking> getBookingsByUser(Integer userId);
	List<Booking> getBookingsByResort(Integer resortId);
}
//•	createBooking
//•	confirmBooking
//•	cancelBooking
//•	completeBooking
//•	getBookingById
//•	getBookingsByUser
//•	getBookingsByResort


//This interface refers to Booking entity.