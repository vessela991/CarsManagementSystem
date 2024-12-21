package com.fmi_plovdiv.CarManagementApplication.service;

import com.fmi_plovdiv.CarManagementApplication.repository.GarageRepository;
import org.springframework.stereotype.Service;

@Service
public class GarageService {
    private GarageRepository garageRepository;
    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }
}
