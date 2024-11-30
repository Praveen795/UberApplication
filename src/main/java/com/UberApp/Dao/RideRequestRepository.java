package com.UberApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UberApp.entities.RideRequest;
@Repository
public interface RideRequestRepository extends JpaRepository<RideRequest, Long>{

}
