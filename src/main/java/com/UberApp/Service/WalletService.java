package com.UberApp.Service;

import com.UberApp.entities.Ride;
import com.UberApp.entities.User;
import com.UberApp.entities.Wallet;
import com.UberApp.entities.enums.TransactionMethod;

public interface WalletService {
	
	Wallet addMoneyToWallet(User user, double amount,String transactionId, Ride ride , TransactionMethod transactionMethod);
	
	Wallet deductMoneyFromWallet(User user, double amount, String transactionId, Ride ride,
			TransactionMethod transactionMethod);
	
	Wallet findWalletById(long walletId);
	
	Wallet createNewWallet(User user);
	
	void withdrawAllMyMoneyFromWallet();
	
	Wallet findWalletByUser(User user);

}
