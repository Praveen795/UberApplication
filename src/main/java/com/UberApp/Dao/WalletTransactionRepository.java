package com.UberApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UberApp.entities.WalletTransaction;

public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {

}
