package com.fmi_plovdiv.CarManagementApplication.service;

import com.fmi_plovdiv.CarManagementApplication.dto.*;
import com.fmi_plovdiv.CarManagementApplication.model.Garage;
import com.fmi_plovdiv.CarManagementApplication.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GarageService {
    private GarageRepository garageRepository;
    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public ResponseGarageDto getById(Long id) {
        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Garage with id %s not found", id)));
        return ResponseGarageDto.fromGarage(garage);
    }

    public ResponseGarageDto update(Long id, UpdateGarageDto updateGarageDTO) {
        Garage garage = garageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Garage with id %s not found", id)));
        Garage updatedGarage = garageRepository.save(Garage.fromUpdateGarageDto(garage.getId(), updateGarageDTO));
        return ResponseGarageDto.fromGarage(updatedGarage);
    }

    public void delete(Long id) {
        garageRepository.deleteById(id);
    }

    public List<ResponseGarageDto> getAll() {
        List<ResponseGarageDto> responseGarageDtoList = new ArrayList<>();
        garageRepository.findAll().forEach(garage -> responseGarageDtoList.add(ResponseGarageDto.fromGarage(garage)));
        return responseGarageDtoList;
    }

    public ResponseGarageDto create(CreateGarageDto createGarageDTO) {
        Garage savedGarage = garageRepository.save(Garage.fromCreateGarageDto(createGarageDTO));
        return ResponseGarageDto.fromGarage(savedGarage);
    }

    public List<GarageDailyAvailabilityReportDto> getReport(Long garageId, String startDate, String endDate) {
        List<GarageDailyAvailabilityReportDto> responseGarageDailyAvailabilityReportDtoList = new ArrayList<>();
        //TODO: query the DB
        return responseGarageDailyAvailabilityReportDtoList;
    }
}
