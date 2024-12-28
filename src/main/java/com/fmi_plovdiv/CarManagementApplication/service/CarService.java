package com.fmi_plovdiv.CarManagementApplication.service;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateCarDto;
import com.fmi_plovdiv.CarManagementApplication.dto.ResponseCarDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateCarDto;
import com.fmi_plovdiv.CarManagementApplication.exception.NotFoundException;
import com.fmi_plovdiv.CarManagementApplication.model.Car;
import com.fmi_plovdiv.CarManagementApplication.model.Garage;
import com.fmi_plovdiv.CarManagementApplication.repository.CarRepository;
import com.fmi_plovdiv.CarManagementApplication.repository.CarSpecifications;
import com.fmi_plovdiv.CarManagementApplication.repository.GarageRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final GarageRepository garageRepository;

    public CarService(CarRepository carRepository, GarageRepository garageRepository) {
        this.carRepository = carRepository;
        this.garageRepository = garageRepository;
    }

    public ResponseCarDto getById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Car with ID %s not found", id)));
        return getResponseCarDto(car);
    }

    public ResponseCarDto update(Long id, UpdateCarDto updateCarDTO) {
        Car car = carRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Car with ID %s not found", id)));
        Car updatedCar = carRepository.save(Car.fromUpdateCarDto(car.getId(), updateCarDTO));
        return getResponseCarDto(updatedCar);
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public List<ResponseCarDto> getAll(String make, Long garageId, Integer fromYear, Integer toYear) {
        List<ResponseCarDto> responseCarDtosList = new ArrayList<>();

        Specification<Car> spec = Specification
                .where(CarSpecifications.hasCarMake(make))
                .and(CarSpecifications.hasGarageId(garageId))
                .and(CarSpecifications.hasFromYear(fromYear))
                .and(CarSpecifications.hasToYear(toYear));

        carRepository.findAll(spec).forEach(car -> {
            ResponseCarDto responseCarDto = getResponseCarDto(car);
            responseCarDtosList.add(responseCarDto);
        });

        return responseCarDtosList;
    }

    public ResponseCarDto create(CreateCarDto createCarDTO) {
        Car savedCar = carRepository.save(Car.fromCreateCarDto(createCarDTO));
        return getResponseCarDto(savedCar);
    }

    private ResponseCarDto getResponseCarDto(Car savedCar) {
        List<Garage> garagesLinked = new ArrayList<>();
        for (Long garageId : savedCar.getGarageIds()) {
            Garage garage = garageRepository.findById(garageId).orElseThrow(() -> new NotFoundException(String.format("Garage with ID %s not found", garageId)));
            garagesLinked.add(garage);
        }
        return ResponseCarDto.fromCar(savedCar, garagesLinked);
    }
}
