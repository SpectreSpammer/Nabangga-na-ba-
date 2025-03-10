package com.rnit.Nabangga_na_ba.entity;


import com.rnit.Nabangga_na_ba.converter.StringListConverter;
import com.rnit.Nabangga_na_ba.enums.CarBrands;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "The plate number is required!")
    @Column(nullable = false, unique = true)
    private String plateNo;

    @NotNull(message = "The brand is required!")
    @Enumerated(EnumType.STRING) // Stores as a String in the database
    @Column(nullable = false)
    private CarBrands brand;

    @NotEmpty(message = "The category is required!")
    @Pattern(regexp = "Sedan|SUV|Truck|Van", message = "Invalid category selected")
    @Column(nullable = false)
    private String category;

    @NotEmpty(message = "The model name is required!")
    @Column(nullable = false)
    private String modelName;

    @NotEmpty(message = "The color is required!")
    @Column(nullable = false)
    private String color;

    @NotEmpty(message = "The location is required!")
    @Column(nullable = false)
    private String location;

    // Stores multiple image file names as a comma-separated string
    @Convert(converter = StringListConverter.class)
    @Column(nullable = true)
    private List<String> imageFileNames = new ArrayList<>();

    @PastOrPresent(message = "Created date must be in the past or present!")
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccidentHistory> accidentHistories = new ArrayList<>();


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

    public List<AccidentHistory> getAccidentHistories() {
        return accidentHistories;
    }

    public void setAccidentHistories(List<AccidentHistory> accidentHistories) {
        this.accidentHistories = accidentHistories;
    }
}
