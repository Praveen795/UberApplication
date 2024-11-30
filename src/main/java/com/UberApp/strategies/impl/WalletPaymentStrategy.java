package com.UberApp.strategies.impl;

import org.springframework.stereotype.Service;

import com.UberApp.Service.WalletService;
import com.UberApp.entities.Driver;
import com.UberApp.entities.Payment;
import com.UberApp.entities.Rider;
import com.UberApp.entities.enums.TransactionMethod;
import com.UberApp.strategies.PaymentStrategy;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy  implements PaymentStrategy{
	
	private final WalletService walletService;

	@Override
	public void processPayment(Payment payment) {
		
		Rider rider=payment.getRide().getRider();
		Driver driver=payment.getRide().getDriver();
		
		walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount(), 
				                            null, payment.getRide(), TransactionMethod.RIDE);
		
		double driverRide_amount=payment.getAmount()*(1-platfrm_commission);
		
		walletService.addMoneyToWallet(driver.getUser(), driverRide_amount, null,
				payment.getRide(), TransactionMethod.RIDE);
		
		
	}

}
