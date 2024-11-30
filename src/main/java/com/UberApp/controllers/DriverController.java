package com.UberApp.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UberApp.Dto.DriverDto;
import com.UberApp.Dto.OtpDto;
import com.UberApp.Dto.RideDto;
import com.UberApp.Service.DriverService;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {
	
	private final DriverService driverService;
	
	@PostMapping("/acceptRide/{rideRequestId}")
	public ResponseEntity<RideDto> acceptRide(@PathVariable long rideRequestId){
		
		return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
	}
	
	
	@PostMapping("/startRide/{rideId}")
	public ResponseEntity<RideDto> startRide(@PathVariable long rideId, @RequestBody OtpDto otpDto){
		
		RideDto startRide = driverService.startRide(rideId,otpDto.getOpt());
		return new ResponseEntity<>(startRide,HttpStatus.OK);
	}
	
	
	@PostMapping("/cancleRide/{rideId}")
	public ResponseEntity<RideDto> cancleRide(@PathVariable long rideId){
		
		RideDto canceldRide = driverService.cancleRide(rideId);
		return new ResponseEntity<>(canceldRide,HttpStatus.OK);
	}
	
	
	@GetMapping("/getProfile/")
	public ResponseEntity<DriverDto> getMyProfile() {
		
		DriverDto myProfile = driverService.getMyProfile();
		return new ResponseEntity<>(myProfile,HttpStatus.OK);
	}
	
	
	@GetMapping("/allRides/{pageSize}/{pageNumber}")
	public ResponseEntity<Page<RideDto>> getAllMyRides(@PathVariable int pageSize ,@PathVariable int pageNumber){
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize,Sort.by("rideId").ascending());
		 Page<RideDto> rides = driverService.getAllMyRides(pageRequest);
		return new ResponseEntity<>(rides,HttpStatus.OK);
		
		
	}
	
	
	
	
	

}
