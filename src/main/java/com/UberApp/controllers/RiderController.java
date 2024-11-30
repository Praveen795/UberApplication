package com.UberApp.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UberApp.Dto.RideDto;
import com.UberApp.Dto.RideRequestDto;
import com.UberApp.Dto.RiderDto;
import com.UberApp.Service.RiderService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {
	
	private final RiderService riderService;
	
	
	

	@PostMapping("/rideRequest")
	public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto){
		
		RideRequestDto createdRideRequestDto=riderService.requestRide(rideRequestDto);
		
		return new ResponseEntity<>(createdRideRequestDto,HttpStatus.OK);
		
	}
	
	@PostMapping("/cancleRide/{rideId}")
	public ResponseEntity<RideDto> cancleRide(@PathVariable long rideId){
		RideDto rideDto = riderService.cancleRide(rideId);
		return new ResponseEntity<>(rideDto,HttpStatus.OK);
	}
	
	@GetMapping("/getMyProfile")
	public ResponseEntity<RiderDto> getMyProfile() {
		RiderDto myProfile = riderService.getMyProfile();
		return new ResponseEntity<>(myProfile,HttpStatus.FOUND);
	}
	
	@GetMapping("/allRides/{pageSize}/{pageNumber}")
	public ResponseEntity<Page<RideDto>> getAllRidesofRider(@PathVariable int pageSize, @PathVariable int pageNumber){
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		Page<RideDto> allMyRides = riderService.getAllMyRides(pageRequest);
		return new ResponseEntity<>(allMyRides,HttpStatus.OK);
	}
	

}
