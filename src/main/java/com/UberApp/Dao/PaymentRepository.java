package com.UberApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UberApp.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
