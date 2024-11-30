package com.UberApp.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import com.UberApp.entities.enums.PaymentMethod;
import com.UberApp.entities.enums.RideRequestStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RideRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rideRequestId;
	
	@Column(columnDefinition = "Geometry(Point,4326)")
	private Point pickUpLocation;
	
	@Column(columnDefinition = "Geometry(Point,4326)")
	private Point dropUpLocation;	
	
	private Double fare;
	@CreationTimestamp
	private LocalDateTime requiedTime;
	@ManyToOne(fetch = FetchType.LAZY)
	private Rider rider;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	@Enumerated(EnumType.STRING)
	private RideRequestStatus rideRequestStatus; 
	
	
	
	

	
	
	
	
	
	
	
	
	
	
}
