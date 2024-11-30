package com.UberApp.Dto;

import java.time.LocalDateTime;


import com.UberApp.entities.enums.TransactionMethod;
import com.UberApp.entities.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletTransactionDto {
	
	private long walletTrasactionId;
	
	private Double amount;
	
	private TransactionType transactionType;
	
	private TransactionMethod transactionMethod;
	
	private RideDto ride;
	
	private String transactionId;
	
	
	private LocalDateTime timeStamp;
	
	private WalletDto wallet;
	

}
