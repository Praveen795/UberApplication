package com.UberApp.entities;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long driverId;
	private Double rating;
	private String vahicleId;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	private boolean available;
	
	
	@Column(columnDefinition = "Geometry(Point,4326)")
	private Point currentLocation;
	

}
