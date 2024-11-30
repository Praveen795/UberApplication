package com.UberApp.ServiceImpl;

import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.UberApp.Service.DistanceService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Service
public class DistanceServiceImpl implements DistanceService {
	
	private static final String OSRM_BASE_URI="https://router.project-osrm.org/route/v1/driving/";

	@Override
	public Double calculateDistance(Point source, Point destination)  {
	
		try {
			
			String uri=source.getX()+","+source.getY()+";"+destination.getX()+","+destination.getY();
			
			OSRMResponseDto osrmResponseDto = RestClient
			.builder()
			.baseUrl(OSRM_BASE_URI)
			.build()
			.get()
			.uri(uri)
			.retrieve()
			 .body(OSRMResponseDto.class);
		    return osrmResponseDto.getRoutes().get(0).getDistance();
		    
		}catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error getting data from OSRM: " + e.getMessage(), e);
		} 
		
	}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
static  class OSRMResponseDto{
	private List<OSRMRoute> routes;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
static  class OSRMRoute{
	private Double distance;
}

}
