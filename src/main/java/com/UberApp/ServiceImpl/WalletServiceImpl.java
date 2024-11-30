package com.UberApp.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.UberApp.Dao.WalletRepository;
import com.UberApp.Dto.WalletTransactionDto;
import com.UberApp.Exception.ResourceNotFoundException;
import com.UberApp.Service.WalletService;
import com.UberApp.Service.WalletTransactionService;
import com.UberApp.entities.Ride;
import com.UberApp.entities.User;
import com.UberApp.entities.Wallet;
import com.UberApp.entities.WalletTransaction;
import com.UberApp.entities.enums.TransactionMethod;
import com.UberApp.entities.enums.TransactionType;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
	
	private final WalletRepository walletRepository;
	private final WalletTransactionService walletTransactionService;
	private final ModelMapper modelMapper;

	@Override
	@Transactional
	public Wallet addMoneyToWallet(User user, double amount,
			                       String transactionId, Ride ride,
			                       TransactionMethod transactionMethod) {

		Wallet wallet = findWalletByUser(user);
		wallet.setBalance(wallet.getBalance() + amount);
		Wallet savedWallet = walletRepository.save(wallet);

		WalletTransaction transaction = WalletTransaction.builder()
				.amount(amount)
				.ride(ride)
				.wallet(wallet)
				.transactionMethod(transactionMethod)
				.transactionType(TransactionType.CREDIT)
				.transactionId(transactionId)
				.build();
		
		walletTransactionService.createNewTransaction(modelMapper.map(transaction, WalletTransactionDto.class));

		return savedWallet;
	}

	@Override
	@Transactional
	public Wallet deductMoneyFromWallet(User user, double amount,
			                            String transactionId, Ride ride,
			                            TransactionMethod transactionMethod) {

		Wallet wallet = findWalletByUser(user);
		wallet.setBalance(wallet.getBalance() - amount);
		Wallet savedWallet = walletRepository.save(wallet);

		WalletTransaction transaction = WalletTransaction.builder()
				.amount(amount)
				.transactionId(transactionId)
				.wallet(wallet)
				.transactionMethod(transactionMethod)
				.transactionType(TransactionType.DEBIT)
				.ride(ride)
				.build();

		walletTransactionService.createNewTransaction(modelMapper.map(transaction, WalletTransactionDto.class));
		return savedWallet;
	}

	@Override
	public Wallet findWalletById(long walletId) {
		Wallet wallet = walletRepository.findById(walletId)
		.orElseThrow(()->new ResourceNotFoundException("walletId","wallet not found with this id"+walletId,HttpStatus.NOT_FOUND));
		return wallet;
	}

	@Override
	public Wallet createNewWallet(User user) {
		Wallet wallet=new Wallet();
		wallet.setUser(user);
		Wallet savdWallet = walletRepository.save(wallet);
		
		return savdWallet;
	}

	@Override
	public void withdrawAllMyMoneyFromWallet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Wallet findWalletByUser(User user) {
		Wallet wallet = walletRepository.findByUser(user)
				.orElseThrow(()->new ResourceNotFoundException("user","wallet not found with this user",HttpStatus.NOT_FOUND));
			return wallet;
	}

	

}
