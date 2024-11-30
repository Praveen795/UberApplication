package com.UberApp.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


import com.UberApp.entities.enums.TransactionMethod;
import com.UberApp.entities.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WalletTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long walletTrasactionId;
	
	private Double amount;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	@Enumerated(EnumType.STRING)
	private TransactionMethod transactionMethod;
	@OneToOne(fetch = FetchType.LAZY)
	private Ride ride;
	
	private String transactionId;
	
	@CreationTimestamp
	private LocalDateTime timeStamp;
	@ManyToOne(fetch = FetchType.LAZY)
	private Wallet wallet;
	
	
	
	
	
	

}
