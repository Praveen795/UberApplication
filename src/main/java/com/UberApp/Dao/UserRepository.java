package com.UberApp.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UberApp.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByemail(String email);

}
