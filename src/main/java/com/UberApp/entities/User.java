package com.UberApp.entities;

import java.util.Set;


import com.UberApp.entities.enums.Role;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "uber_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.LAZY)
	private Set<Role> role;

}
