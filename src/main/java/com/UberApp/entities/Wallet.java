package com.UberApp.entities;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long walletId;
	@OneToOne(fetch = FetchType.LAZY ,optional =false)
	private User user;
	
	private Double balance=0.0;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "wallet")
	List<WalletTransaction> walletTransactions;
	

}
