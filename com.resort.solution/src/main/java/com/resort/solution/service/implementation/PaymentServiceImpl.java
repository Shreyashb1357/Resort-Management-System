package com.resort.solution.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.solution.entity.Payment;
import com.resort.solution.enums.PaymentStatus;
import com.resort.solution.repository.PaymentRepository;
import com.resort.solution.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository payRepo;

	@Override
	public Payment initiatePayment(Payment payment) {
		if(payment == null || payment.getBooking() == null) {
			return null;
		}
		return payRepo.save(payment);
	}

	@Override
	public boolean confirmPayment(Integer paymentId, PaymentStatus paymentStatus) {
		Payment pay = payRepo.findById(paymentId).orElse(null);
		if(pay == null) {
			return false;
		}
		pay.setPaymentStatus(paymentStatus);
		payRepo.save(pay);
		return true;
	}

	@Override
	public boolean failPayment(Integer paymentId, PaymentStatus paymentStatus) {
		Payment pay = payRepo.findById(paymentId).orElse(null);
		if(pay == null) {
			return false;
		}
		pay.setPaymentStatus(paymentStatus);
		payRepo.save(pay);
		return true;
	}

	@Override
	public List<Payment> getPaymentsByBooking(Integer bookingId) {
		List<Payment> pays = payRepo.findByBooking_BookingId(bookingId);
		return pays;
	}

}
