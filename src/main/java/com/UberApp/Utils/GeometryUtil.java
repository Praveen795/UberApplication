package com.UberApp.Utils;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

import com.UberApp.Dto.PointDto;

public class GeometryUtil {
	
	/*
	 * this static method is convert PointDto to geometry Points based on 4326  
	 */
	
	public static Point craetedPoint(PointDto pointDto) {
		
		GeometryFactory geometryFactory=new GeometryFactory(new PrecisionModel(),4326);
		Coordinate coordinate=new Coordinate(pointDto.getCoordinates()[0], pointDto.getCoordinates()[1]);
		return geometryFactory.createPoint(coordinate);
	}

}
