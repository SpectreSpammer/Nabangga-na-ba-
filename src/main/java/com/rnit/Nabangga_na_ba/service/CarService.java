package com.rnit.Nabangga_na_ba.service;

import com.rnit.Nabangga_na_ba.dto.CarDto;
import com.rnit.Nabangga_na_ba.entity.Cars;
import com.rnit.Nabangga_na_ba.mapper.CarMapper;
import com.rnit.Nabangga_na_ba.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final String UPLOAD_DIR = "uploads/"; // Directory to store images

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(CarMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<CarDto> getCarById(int id) {
        return carRepository.findById(id)
                .map(CarMapper::toDto);
    }

    public Optional<CarDto> getCarByPlateNo(String plateNo) {
        return carRepository.findByPlateNo(plateNo)
                .map(CarMapper::toDto);
    }

    @Transactional
    public CarDto saveCar(CarDto carDto, List<MultipartFile> images) throws IOException {
        Cars car = CarMapper.toEntity(carDto);

        // Save images if provided
        if (images != null && !images.isEmpty()) {
            List<String> imageFileNames = saveImages(images);
            car.setImageFileNames(imageFileNames);
        }

        car = carRepository.save(car);
        return CarMapper.toDto(car);
    }

    @Transactional
    public Optional<CarDto> updateCar(int id, CarDto updatedCarDto, List<MultipartFile> images) throws IOException {
        return carRepository.findById(id).map(existingCar -> {
            existingCar.setPlateNo(updatedCarDto.getPlateNo());
            existingCar.setBrand(updatedCarDto.getBrand());
            existingCar.setCategory(updatedCarDto.getCategory());
            existingCar.setModelName(updatedCarDto.getModelName());
            existingCar.setColor(updatedCarDto.getColor());
            existingCar.setLocation(updatedCarDto.getLocation());

            // Handle new images if provided
            if (images != null && !images.isEmpty()) {
                try {
                    List<String> imageFileNames = saveImages(images);
                    existingCar.setImageFileNames(imageFileNames);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to save images", e);
                }
            }

            Cars savedCar = carRepository.save(existingCar);
            return CarMapper.toDto(savedCar);
        });
    }

    @Transactional
    public boolean deleteCar(int id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private List<String> saveImages(List<MultipartFile> images) throws IOException {
        if (!Files.exists(Paths.get(UPLOAD_DIR))) {
            Files.createDirectories(Paths.get(UPLOAD_DIR));
        }

        return images.stream().map(image -> {
            try {
                String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
                Path filePath = Paths.get(UPLOAD_DIR + fileName);
                Files.write(filePath, image.getBytes());
                return fileName;
            } catch (IOException e) {
                throw new RuntimeException("Error saving image: " + image.getOriginalFilename(), e);
            }
        }).collect(Collectors.toList());
    }
}
