package com.resort.solution.service;

import java.util.List;

import com.resort.solution.entity.BookingService;

public interface BookingServiceService {
    BookingService addServiceToBooking(BookingService bookingService);
    boolean removeServiceFromBooking(Integer bookingServiceId);
    List<BookingService> getServicesByBooking(Integer bookingId);
}

//•	addServiceToBooking
//•	removeServiceFromBooking
//•	getServicesByBooking = > get service by bookingId.
