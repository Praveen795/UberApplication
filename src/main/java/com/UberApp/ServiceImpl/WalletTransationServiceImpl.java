package com.UberApp.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.UberApp.Dao.WalletTransactionRepository;
import com.UberApp.Dto.WalletTransactionDto;
import com.UberApp.Service.WalletTransactionService;
import com.UberApp.entities.WalletTransaction;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletTransationServiceImpl implements WalletTransactionService {
	
	private final WalletTransactionRepository walletTransactionRepository;
	private final ModelMapper modelMapper;

	@Override
	public void createNewTransaction(WalletTransactionDto walletTransactionDto) {
		
		WalletTransaction walletTransaction = modelMapper.map(walletTransactionDto, WalletTransaction.class);
		walletTransactionRepository.save(walletTransaction);	
		
	}

}
