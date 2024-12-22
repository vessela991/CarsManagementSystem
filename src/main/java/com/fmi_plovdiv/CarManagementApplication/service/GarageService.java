package com.fmi_plovdiv.CarManagementApplication.service;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateGarageDto;
import com.fmi_plovdiv.CarManagementApplication.dto.GarageDailyAvailabilityReportDto;
import com.fmi_plovdiv.CarManagementApplication.dto.ResponseGarageDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateGarageDto;
import com.fmi_plovdiv.CarManagementApplication.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {
    private GarageRepository garageRepository;
    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public ResponseGarageDto getById(Long id) {
    }

    public ResponseGarageDto update(Long id, UpdateGarageDto updateGarageDTO) {
    }

    public void delete(Long id) {
    }

    public List<ResponseGarageDto> getAll() {
    }

    public ResponseGarageDto create(CreateGarageDto createGarageDTO) {
    }

    public List<GarageDailyAvailabilityReportDto> getReport(Long garageId, String startDate, String endDate) {
    }
}
