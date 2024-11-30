package com.UberApp.ServiceImpl;

import org.springframework.stereotype.Service;

import com.UberApp.Service.PaymentService;
import com.UberApp.entities.Payment;
import com.UberApp.entities.Ride;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl  implements PaymentService{

	@Override
	public void processPayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Payment createNewPayment(Ride ride) {
		// TODO Auto-generated method stub
		return null;
	}

}
