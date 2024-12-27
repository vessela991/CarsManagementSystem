package com.fmi_plovdiv.CarManagementApplication.controller;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateCarDto;
import com.fmi_plovdiv.CarManagementApplication.dto.ResponseCarDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateCarDto;
import com.fmi_plovdiv.CarManagementApplication.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@Validated
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCarDto> getCarById(@PathVariable Long id) {
        ResponseCarDto responseCarDto = carService.getById(id);
        return ResponseEntity.ok(responseCarDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCarDto> updateCar(@PathVariable Long id, @RequestBody @Valid UpdateCarDto updateCarDTO) {
        ResponseCarDto responseCarDto = carService.update(id, updateCarDTO);
        return ResponseEntity.ok(responseCarDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ResponseCarDto>> getAllCars(@RequestParam(required = false) String carMake,
                                                           @RequestParam(required = false) Long garageId) {
        List<ResponseCarDto> responseCarDtosList = carService.getAll(carMake, garageId);
        return ResponseEntity.ok(responseCarDtosList);
    }

    @PostMapping
    public ResponseEntity<ResponseCarDto> createCar(@RequestBody @Valid CreateCarDto createCarDTO) {
        ResponseCarDto responseCarDto = carService.create(createCarDTO);
        return ResponseEntity.ok(responseCarDto);
    }
}