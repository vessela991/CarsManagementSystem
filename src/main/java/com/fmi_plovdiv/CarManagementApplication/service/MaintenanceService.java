package com.fmi_plovdiv.CarManagementApplication.service;

import com.fmi_plovdiv.CarManagementApplication.dto.*;
import com.fmi_plovdiv.CarManagementApplication.model.Maintenance;
import com.fmi_plovdiv.CarManagementApplication.repository.CarRepository;
import com.fmi_plovdiv.CarManagementApplication.repository.GarageRepository;
import com.fmi_plovdiv.CarManagementApplication.repository.MaintenanceRepository;
import com.sun.tools.javac.Main;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;
    private final CarService carService;
    private final GarageService garageService;

    public MaintenanceService(MaintenanceRepository maintenanceRepository, CarService carService, GarageService garageService) {
        this.maintenanceRepository = maintenanceRepository;
        this.carService = carService;
        this.garageService = garageService;
    }

    public ResponseMaintenanceDto getById(Long id) {
        Maintenance maintenance = maintenanceRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Maintenance with id %s not found", id)));
        ResponseCarDto car = carService.getById(maintenance.getCarId());
        ResponseGarageDto garage = garageService.getById(maintenance.getGarageId());
        //get car info and garage info
        return ResponseMaintenanceDto.fromMaintenance(maintenance, car.getMake(), garage.getName());
    }

    public ResponseMaintenanceDto update(Long id, UpdateMaintenanceDto updateMaintenanceDTO) {
        Maintenance maintenance = maintenanceRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Maintenance with id %s not found", id)));
        Maintenance updatedMaintenance = maintenanceRepository.save(Maintenance.fromUpdateMaintenanceDto(id, updateMaintenanceDTO));
        ResponseCarDto car = carService.getById(maintenance.getCarId());
        ResponseGarageDto garage = garageService.getById(maintenance.getGarageId());
        //get car info and garage info
        return ResponseMaintenanceDto.fromMaintenance(maintenance, car.getMake(), garage.getName());
    }

    public void delete(Long id) {
        maintenanceRepository.deleteById(id);
    }

    public List<ResponseMaintenanceDto> getAll() {
        List<Maintenance> maintenances = new ArrayList<>();
        maintenanceRepository.findAll().forEach(maintenances::add);
        List<ResponseMaintenanceDto> responseMaintenanceDtos = new ArrayList<>();
        for (Maintenance maintenance : maintenances) {
            ResponseCarDto car = carService.getById(maintenance.getCarId());
            ResponseGarageDto garage = garageService.getById(maintenance.getGarageId());
            responseMaintenanceDtos.add(ResponseMaintenanceDto.fromMaintenance(maintenance, car.getMake(), garage.getName()));
        }
        return responseMaintenanceDtos;
    }

    public ResponseMaintenanceDto create(CreateMaintenanceDto createMaintenanceDTO) {
        Maintenance savedMaintenance = maintenanceRepository.save(Maintenance.fromCreateMaintenanceDto(createMaintenanceDTO));
        ResponseCarDto car = carService.getById(createMaintenanceDTO.getCarId());
        ResponseGarageDto garage = garageService.getById(createMaintenanceDTO.getGarageId());
        return ResponseMaintenanceDto.fromMaintenance(savedMaintenance, car.getMake(), garage.getName());
    }

    public List<MonthlyRequestsReportDto> getMonthlyRequestReport(Long garageId, String startMonth, String endMonth) {
        List<MonthlyRequestsReportDto> monthlyRequestsReportDtos = new ArrayList<>();
        //TODO: do request to DB
        return monthlyRequestsReportDtos;
    }
}
