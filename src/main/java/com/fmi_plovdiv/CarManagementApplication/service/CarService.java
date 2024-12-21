package com.fmi_plovdiv.CarManagementApplication.service;

import com.fmi_plovdiv.CarManagementApplication.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


}
