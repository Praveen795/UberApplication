package com.UberApp.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UberApp.entities.User;
import com.UberApp.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

	Optional<Wallet> findByUser(User user);

}
