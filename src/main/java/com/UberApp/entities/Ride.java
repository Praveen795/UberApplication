package com.UberApp.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import com.UberApp.entities.enums.PaymentMethod;

import com.UberApp.entities.enums.RideStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@AllArgsConstructor
@NoArgsConstructor
public class Ride {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rideId;
	
	private String otp;
	
	@Column(columnDefinition = "Geometry(Point,4326)")
	private Point pickUpLocation;
	

	@Column(columnDefinition = "Geometry(Point,4326)")
	private Point dropUpLocation;	
	@CreationTimestamp
	private LocalDateTime createdTime;
	@ManyToOne
	private Rider rider;
	@ManyToOne
	private Driver driver;
	
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	@Enumerated(EnumType.STRING)
	private RideStatus rideStatus; 
	
	private Double fare;
	
	private LocalDateTime startedAt;
	
	private LocalDateTime endedAt;
	

}
