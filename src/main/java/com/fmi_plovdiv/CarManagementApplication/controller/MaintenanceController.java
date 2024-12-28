package com.fmi_plovdiv.CarManagementApplication.controller;

import com.fmi_plovdiv.CarManagementApplication.dto.*;
import com.fmi_plovdiv.CarManagementApplication.repository.MaintenanceRepository;
import com.fmi_plovdiv.CarManagementApplication.service.MaintenanceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
@Validated
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService, MaintenanceRepository maintenanceRepository) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMaintenanceDto> getMaintenanceById(@PathVariable Long id) {
        ResponseMaintenanceDto maintenance = maintenanceService.getById(id);
        return ResponseEntity.ok(maintenance);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMaintenanceDto> updateMaintenance(@PathVariable Long id, @RequestBody @Valid UpdateMaintenanceDto updateMaintenanceDTO) {
        ResponseMaintenanceDto responseMaintenanceDto = maintenanceService.update(id, updateMaintenanceDTO);
        return ResponseEntity.ok(responseMaintenanceDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long id) {
        maintenanceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ResponseMaintenanceDto>> getAllMaintenances(@RequestParam(required = false) Long carId,
                                                                           @RequestParam(required = false) Long garageId) {
        List<ResponseMaintenanceDto> responseMaintenanceDtosList = maintenanceService.filter(carId, garageId);
        return ResponseEntity.ok(responseMaintenanceDtosList);
    }

    @PostMapping
    public ResponseEntity<ResponseMaintenanceDto> createMaintenance(@RequestBody @Valid CreateMaintenanceDto createMaintenanceDTO) {
        ResponseMaintenanceDto responseMaintenanceDto = maintenanceService.create(createMaintenanceDTO);
        return ResponseEntity.ok(responseMaintenanceDto);
    }

    @GetMapping("/monthlyRequestsReport")
    public ResponseEntity<List<MonthlyRequestsReportDto>> monthlyRequestsReport(@RequestParam Long garageId,
                                                                                @RequestParam String startMonth,
                                                                                @RequestParam String endMonth) {
        List<MonthlyRequestsReportDto> monthlyRequestsReportDtos =
                maintenanceService.getMonthlyRequestReport(garageId, startMonth, endMonth);
        return ResponseEntity.ok(monthlyRequestsReportDtos);
    }
}