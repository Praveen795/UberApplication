package com.UberApp.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UberApp.entities.Ride;
@Repository
public interface RideRepository  extends JpaRepository<Ride, Long>{
	
	Page<Ride> getAllRideBydriverId(long driverId);
	
	Page<Ride> getAllRideByriderId(long riderId);

}
