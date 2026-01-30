package com.resort.solution.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.solution.entity.BookingService;
import com.resort.solution.repository.BookingServiceRepository;
import com.resort.solution.service.BookingServiceService;

@Service
public class BookingServiceServiceImpl implements BookingServiceService {
	
	@Autowired
	private BookingServiceRepository bookingServiceRepo;

	@Override
	public BookingService addServiceToBooking(BookingService bookingService) {
		if(bookingService == null || bookingService.getBooking() == null || bookingService.getService() == null) {
			return null;
		}
		return bookingServiceRepo.save(bookingService);
	}

	@Override
	public boolean removeServiceFromBooking(Integer bookingServiceId) {
		Optional<BookingService> bookingService = bookingServiceRepo.findById(bookingServiceId);
		if(bookingService.isEmpty()) {
			return false;
		}
		bookingServiceRepo.deleteById(bookingServiceId);
		return true;
	}

	@Override
	public List<BookingService> getServicesByBooking(Integer bookingId) {
		return bookingServiceRepo.findByBooking_BookingId(bookingId);
	}
 
}
