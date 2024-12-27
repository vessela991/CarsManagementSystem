package com.fmi_plovdiv.CarManagementApplication.service;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateCarDto;
import com.fmi_plovdiv.CarManagementApplication.dto.ResponseCarDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateCarDto;
import com.fmi_plovdiv.CarManagementApplication.model.Car;
import com.fmi_plovdiv.CarManagementApplication.repository.CarRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public ResponseCarDto getById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Car with ID %s not found", id)));
        return ResponseCarDto.fromCar(car);
    }

    public ResponseCarDto update(Long id, UpdateCarDto updateCarDTO) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Car with ID %s not found", id)));
        Car updatedCar = carRepository.save(Car.fromUpdateCarDto(car.getId(), updateCarDTO));
        return ResponseCarDto.fromCar(updatedCar);
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public List<ResponseCarDto> getAll() {
        List<ResponseCarDto> responseCarDtosList = new ArrayList<>();
        carRepository.findAll().forEach(car -> responseCarDtosList.add(ResponseCarDto.fromCar(car)));
        return responseCarDtosList;
    }

    public ResponseCarDto create(@Valid CreateCarDto createCarDTO) {
        Car savedCar = carRepository.save(Car.fromCreateCarDto(createCarDTO));
        return ResponseCarDto.fromCar(savedCar);
    }
}
