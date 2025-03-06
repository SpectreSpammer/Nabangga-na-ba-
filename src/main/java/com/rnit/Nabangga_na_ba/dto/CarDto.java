package com.rnit.Nabangga_na_ba.dto;

import com.rnit.Nabangga_na_ba.enums.CarBrands;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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

    private List<String> imageFileNames; // List of images

    private LocalDateTime createdAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public CarBrands getBrand() {
        return brand;
    }

    public void setBrand(CarBrands brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getImageFileNames() {
        return imageFileNames;
    }

    public void setImageFileNames(List<String> imageFileNames) {
        this.imageFileNames = imageFileNames;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
