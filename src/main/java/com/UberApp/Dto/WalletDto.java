package com.UberApp.Dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletDto {
	
	private long walletId;
	
	private UserDto user;
	
	private Double balance;
	
	List<WalletTransactionDto> walletTransactions;

}
