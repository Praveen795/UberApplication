package com.UberApp.Service;

import com.UberApp.entities.Payment;
import com.UberApp.entities.Ride;

public interface PaymentService {
	
	void processPayment(Payment payment);
	
	Payment createNewPayment(Ride ride);

}
