package com.resort.solution.service.implementation;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.solution.entity.Booking;
import com.resort.solution.enums.BookingStatus;
import com.resort.solution.repository.BookingRepository;
import com.resort.solution.service.BookingServiceInterface;

@Service
public class BookingServiceInterfaceImpl implements BookingServiceInterface {
	
	@Autowired
	private BookingRepository bookingRepo;

	@Override
	public Booking createBooking(Booking booking) {
		if(booking == null || booking.getUser() == null) {
			return null;
		}
		return bookingRepo.save(booking);
	}

	@Override
	public boolean confirmBooking(Integer bookingId, BookingStatus status) {
		Booking newBooking = bookingRepo.findById(bookingId).orElse(null);
		if(newBooking == null) {
			return false;
		}
		newBooking.setBookingStatus(status.CONFIRMED);
		bookingRepo.save(newBooking);
		return true;
	}

	@Override
	public boolean cancelBooking(Integer bookingId, BookingStatus status) {
		Booking newBooking = bookingRepo.findById(bookingId).orElse(null);
		if(newBooking == null) {
			return false;
		}
		newBooking.setBookingStatus(status.CANCELLED);
		bookingRepo.save(newBooking);
		return true;
	}

	@Override
	public boolean completeBooking(Integer bookingId, BookingStatus status) {
		Booking newBooking = bookingRepo.findById(bookingId).orElse(null);
		if(newBooking == null) {
			return false;
		}
		newBooking.setBookingStatus(status.COMPLETED);
		bookingRepo.save(newBooking);
		return true;
	}

	@Override
	public Booking getBookingById(Integer bookingId) {
		Booking booking = bookingRepo.findById(bookingId).orElse(null);
		if(booking == null || booking.getBookingId() == null) {
			return null;
		}
		return booking;
	}

	@Override
	public List<Booking> getBookingsByUser(Integer userId) {
		List<Booking> bookings = bookingRepo.findByUser_UserId(userId);
		return bookings;
	}

	@Override
	public List<Booking> getBookingsByResort(Integer resortId) {
		List<Booking> bookings = bookingRepo.findByResort_ResortId(resortId);
		return bookings;
	}

}
