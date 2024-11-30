package com.UberApp.strategies;

import com.UberApp.entities.Payment;

public interface PaymentStrategy {
	
	static double platfrm_commission=0.3;
	
	void processPayment(Payment payment);

}
