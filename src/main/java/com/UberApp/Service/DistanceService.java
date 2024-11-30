package com.UberApp.Service;

import org.locationtech.jts.geom.Point;

public interface DistanceService {
	
	int DISTANCE_FARE=10;
	
	 Double calculateDistance(Point source, Point destination);

}
