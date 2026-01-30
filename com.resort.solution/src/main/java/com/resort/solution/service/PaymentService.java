package com.resort.solution.service;

import java.util.List;

import com.resort.solution.entity.Payment;
import com.resort.solution.enums.PaymentStatus;

public interface PaymentService {
	Payment initiatePayment(Payment payment);
	boolean confirmPayment(Integer paymentId , PaymentStatus paymentStatus);
	boolean failPayment(Integer paymentId , PaymentStatus paymentStatus);
	List<Payment> getPaymentsByBooking(Integer bookingId);
}

//•	initiatePayment
//•	confirmPayment
//•	failPayment
//•	getPaymentsByBooking
