package com.rnit.Nabangga_na_ba.controller;

import com.rnit.Nabangga_na_ba.dto.CarDto;
import com.rnit.Nabangga_na_ba.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String listCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "car-list"; // Renders car-list.html
    }

    @GetMapping("/new")
    public String showCarForm(Model model) {
        model.addAttribute("carDto", new CarDto());
        return "car-form"; // Renders car-form.html
    }

    @PostMapping
    public String saveCar(@ModelAttribute("carDto") CarDto carDto,
                          @RequestParam("images") List<MultipartFile> images) throws IOException {
        carService.saveCar(carDto, images);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String editCar(@PathVariable int id, Model model) {
        model.addAttribute("carDto", carService.getCarById(id));
        return "car-form";
    }

    @PostMapping("/update/{id}")
    public String updateCar(@PathVariable int id,
                            @ModelAttribute("carDto") CarDto carDto,
                            @RequestParam(value = "images", required = false) List<MultipartFile> images) throws IOException {
        carService.updateCar(id, carDto, images);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}
