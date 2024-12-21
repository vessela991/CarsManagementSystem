package com.fmi_plovdiv.CarManagementApplication.controller;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateCarDto;
import com.fmi_plovdiv.CarManagementApplication.dto.ResponseCarDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateCarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCarDto> getCarById(@PathVariable Long id) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCarDto> updateCar(@PathVariable Long id, @RequestBody UpdateCarDto updateCarDTO) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {

    }

    @GetMapping
    public ResponseEntity<List<ResponseCarDto>> getAllCars(@RequestParam(required = false) String carMake,
                                                           @RequestParam(required = false) Long garageId,
                                                           @RequestParam(required = false) Integer fromYear,
                                                           @RequestParam(required = false) Integer toYear) {

    }

    @PostMapping
    public ResponseEntity<ResponseCarDto> createCar(@RequestBody CreateCarDto createCarDTO) {

    }
}