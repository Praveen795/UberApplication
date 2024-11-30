package com.UberApp.Dto;

import java.time.LocalDateTime;

import com.UberApp.entities.enums.PaymentMethod;
import com.UberApp.entities.enums.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
	
	private Long paymentId;
	
	private PaymentMethod paymentMethod;
	
	private RideDto ride;
	
	private PaymentStatus paymentStatus;
	
	private Double amount;
	
	LocalDateTime paymenTime;

}
