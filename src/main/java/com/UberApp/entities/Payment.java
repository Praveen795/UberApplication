package com.UberApp.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


import com.UberApp.entities.enums.PaymentMethod;
import com.UberApp.entities.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	@OneToOne(fetch = FetchType.LAZY)
	private Ride ride;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	private Double amount;
	@CreationTimestamp
	LocalDateTime paymenTime;

}
