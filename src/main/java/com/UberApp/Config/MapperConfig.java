package com.UberApp.Config;

import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.UberApp.Dto.PointDto;
import com.UberApp.Utils.GeometryUtil;

@Configuration
public class MapperConfig {

    @Bean
    ModelMapper getMapper() {
		ModelMapper mapper=new ModelMapper();
		
		/*
		 * config of modelmaper map PointDto to Point
		 */
		
		mapper.typeMap(PointDto.class, Point.class).setConverter(context->{
			PointDto pointDto=context.getSource();
			
			return GeometryUtil.craetedPoint(pointDto);
		});
		
		/*
		 * config of modelmaper map Point to PointDto
		 */
		
		mapper.typeMap(Point.class, PointDto.class).setConverter(context->{
			Point point=context.getSource();
			double[] coordinates= {
					point.getX(),point.getY()
			};
			return new PointDto(coordinates);
		});
		
		return mapper;
	}

}
