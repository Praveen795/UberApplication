package com.UberApp.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PointDto {
	
	private double[] coordinates;
	
	private String type="Point";

	public PointDto(double[] coordinates) {
		super();
		this.coordinates = coordinates;
	}

	
	
	

}
