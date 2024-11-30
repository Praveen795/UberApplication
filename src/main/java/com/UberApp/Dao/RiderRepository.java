package com.UberApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UberApp.entities.Rider;
@Repository
public interface RiderRepository extends JpaRepository<Rider, Long>{

}
