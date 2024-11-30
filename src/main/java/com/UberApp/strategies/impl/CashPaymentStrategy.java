package com.UberApp.strategies.impl;

import org.springframework.stereotype.Service;

import com.UberApp.Service.WalletService;
import com.UberApp.entities.Driver;
import com.UberApp.entities.Payment;
import com.UberApp.entities.enums.TransactionMethod;
import com.UberApp.strategies.PaymentStrategy;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy{
	
	private final WalletService walletService;

	@Override
	public void processPayment(Payment payment) {

		Driver driver = payment.getRide().getDriver();
		double platfromCommission = payment.getAmount() * platfrm_commission;
		walletService.deductMoneyFromWallet(driver.getUser(), platfromCommission, null, payment.getRide(),
				TransactionMethod.RIDE);

	}

}
