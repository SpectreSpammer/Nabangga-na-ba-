package com.rnit.Nabangga_na_ba.mapper;

import com.rnit.Nabangga_na_ba.dto.CarDto;
import com.rnit.Nabangga_na_ba.entity.Cars;

public class CarMapper {

    public static CarDto toDto(Cars car) {
        CarDto dto = new CarDto();
        dto.setId(car.getId());
        dto.setPlateNo(car.getPlateNo());
        dto.setBrand(car.getBrand());
        dto.setCategory(car.getCategory());
        dto.setModelName(car.getModelName());
        dto.setColor(car.getColor());
        dto.setLocation(car.getLocation());
        dto.setImageFileName(car.getImageFileName());
        dto.setCreatedAt(car.getCreatedAt());
        return dto;
    }

    public static Cars toEntity(CarDto dto) {
        Cars car = new Cars();
        car.setPlateNo(dto.getPlateNo());
        car.setBrand(dto.getBrand());
        car.setCategory(dto.getCategory());
        car.setModelName(dto.getModelName());
        car.setColor(dto.getColor());
        car.setLocation(dto.getLocation());
        car.setImageFileName(dto.getImageFileName());
        car.setCreatedAt(dto.getCreatedAt());
        return car;
    }
}