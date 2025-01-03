package com.fmi_plovdiv.CarManagementApplication.service;

import com.fmi_plovdiv.CarManagementApplication.dto.*;
import com.fmi_plovdiv.CarManagementApplication.exception.NotFoundException;
import com.fmi_plovdiv.CarManagementApplication.model.Garage;
import com.fmi_plovdiv.CarManagementApplication.model.Maintenance;
import com.fmi_plovdiv.CarManagementApplication.repository.GarageRepository;
import com.fmi_plovdiv.CarManagementApplication.repository.GarageSpecifications;
import com.fmi_plovdiv.CarManagementApplication.repository.MaintenanceRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class GarageService {
    private final GarageRepository garageRepository;
    private final MaintenanceRepository maintenanceRepository;

    public GarageService(GarageRepository garageRepository, MaintenanceRepository maintenanceRepository) {
        this.garageRepository = garageRepository;
        this.maintenanceRepository = maintenanceRepository;
    }

    public ResponseGarageDto getById(Long id) {
        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Garage with id %s not found", id)));
        return ResponseGarageDto.fromGarage(garage);
    }

    public ResponseGarageDto update(Long id, UpdateGarageDto updateGarageDTO) {
        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Garage with id %s not found", id)));
        Garage updatedGarage = garageRepository.save(Garage.fromUpdateGarageDto(garage.getId(), updateGarageDTO));
        return ResponseGarageDto.fromGarage(updatedGarage);
    }

    public void delete(Long id) {
        garageRepository.deleteById(id);
    }

    public List<ResponseGarageDto> getAll(String city) {
        List<ResponseGarageDto> responseGarageDtoList = new ArrayList<>();
        Specification<Garage> spec = Specification
                .where(GarageSpecifications.hasCity(city));

        garageRepository.findAll(spec).forEach(garage -> {
            ResponseGarageDto responseGarageDto = ResponseGarageDto.fromGarage(garage);
            responseGarageDtoList.add(responseGarageDto);
        });
        return responseGarageDtoList;
    }

    public ResponseGarageDto create(CreateGarageDto createGarageDTO) {
        Garage savedGarage = garageRepository.save(Garage.fromCreateGarageDto(createGarageDTO));
        return ResponseGarageDto.fromGarage(savedGarage);
    }

    public List<GarageDailyAvailabilityReportDto> getReport(Long garageId, String startDate, String endDate) {
        List<GarageDailyAvailabilityReportDto> responseGarageDailyAvailabilityReportDtoList = new ArrayList<>();
        Garage garage = garageRepository.findById(garageId)
                .orElseThrow(() -> new NotFoundException(String.format("Garage with id %s not found", garageId)));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE).plusDays(1);
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
        while (start.isBefore(end)) {
            GarageDailyAvailabilityReportDto garageDailyAvailabilityReportDto = new GarageDailyAvailabilityReportDto();
            garageDailyAvailabilityReportDto.setDate(start.toString());
            List<Maintenance> maintenances = maintenanceRepository.findByGarageIdAndScheduleDate(garageId, start.toString());
            garageDailyAvailabilityReportDto.setRequests(maintenances.size());
            garageDailyAvailabilityReportDto.setAvailableCapacity(garage.getCapacity() - maintenances.size());
            responseGarageDailyAvailabilityReportDtoList.add(garageDailyAvailabilityReportDto);
            start = start.plusDays(1);
        }
        return responseGarageDailyAvailabilityReportDtoList;
    }
}
