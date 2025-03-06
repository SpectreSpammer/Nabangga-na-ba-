package com.rnit.Nabangga_na_ba.dto;

import com.rnit.Nabangga_na_ba.enums.CarBrands;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CarDto {

    private int id;

    @NotEmpty(message = "The plate number is required!")
    private String plateNo;

    @NotNull(message = "The brand is required!")
    private CarBrands brand;

    @NotEmpty(message = "The category is required!")
    @Pattern(regexp = "Sedan|SUV|Truck|Van", message = "Invalid category selected")
    private String category;

    @NotEmpty(message = "The model name is required!")
    private String modelName;

    @NotEmpty(message = "The color is required!")
    private String color;

    @NotEmpty(message = "The location is required!")
    private String location;

    private String imageFileName;

    private LocalDateTime createdAt;
}
