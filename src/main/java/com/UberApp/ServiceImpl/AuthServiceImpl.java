package com.UberApp.ServiceImpl;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.UberApp.Dao.UserRepository;
import com.UberApp.Dto.DriverDto;
import com.UberApp.Dto.SignUpDto;
import com.UberApp.Dto.UserDto;
import com.UberApp.Exception.RuntimeConflictException;

import com.UberApp.Service.AuthService;
import com.UberApp.Service.RiderService;
import com.UberApp.Service.WalletService;
import com.UberApp.entities.User;
import com.UberApp.entities.enums.Role;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl  implements AuthService{
	
	private final UserRepository userRepository;
	private final RiderService riderService;
	private final ModelMapper modelMapper;
	private final WalletService walletService;
	
	@Override
	public String logIn(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public UserDto sighUp(SignUpDto signUpDto) {
		User user = userRepository.findByemail(signUpDto.getEmail()).orElse(null);
		if (user != null) {
			throw new RuntimeConflictException("email is already exist" + signUpDto.getEmail(), 
					HttpStatus.CONFLICT);

		}

		User mappedUser = modelMapper.map(signUpDto, User.class);
		mappedUser.setRole(Set.of(Role.RIDER));
		User savedUser = userRepository.save(mappedUser);
		riderService.createNewRider(savedUser);
		walletService.createNewWallet(savedUser);
		
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public DriverDto onBordingDriver(long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
