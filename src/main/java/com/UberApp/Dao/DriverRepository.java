package com.UberApp.Dao;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.UberApp.entities.Driver;

@Repository
public interface DriverRepository  extends JpaRepository<Driver, Long>{
	
	

	 @Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickUpLocation) AS distance "
	            + "FROM driver d "
	            + "WHERE d.available = true AND ST_DWithin(d.current_location, :pickUpLocation, 1000) "
	            + "ORDER BY distance "
	            + "LIMIT 10", nativeQuery = true)
	List<Driver> findNearestDriver(Point pickUpLocation);
	 
	 @Query(value = "SELECT d.* "
	 		+ "FROM driver d "
	 		+ "WHERE d.available = true AND ST_DWithin(d.current_location, :pickUpLocation, 1500) "
	 		+ "ORDER BY d.rating DESC "
	 		+ "LIMIT 10",nativeQuery = true)
	 List<Driver> findTenNearByTopRatedDriver(Point pickUpLocation);
	 
	 

}
