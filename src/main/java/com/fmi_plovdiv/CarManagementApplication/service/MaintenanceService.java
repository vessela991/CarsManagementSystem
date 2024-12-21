package com.fmi_plovdiv.CarManagementApplication.service;

import com.fmi_plovdiv.CarManagementApplication.repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {
    private MaintenanceRepository maintenanceRepository;
    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }
}
