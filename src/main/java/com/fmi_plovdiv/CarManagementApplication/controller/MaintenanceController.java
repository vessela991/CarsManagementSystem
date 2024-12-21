package com.fmi_plovdiv.CarManagementApplication.controller;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateMaintenanceDto;
import com.fmi_plovdiv.CarManagementApplication.dto.MonthlyRequestsReportDto;
import com.fmi_plovdiv.CarManagementApplication.dto.ResponseMaintenanceDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateMaintenanceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMaintenanceDto> getMaintenanceById(@PathVariable Long id) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMaintenanceDto> updateMaintenance(@PathVariable Long id, @RequestBody UpdateMaintenanceDto updateMaintenanceDTO) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long id) {

    }

    @GetMapping
    public ResponseEntity<List<ResponseMaintenanceDto>> getAllMaintenances(@RequestParam(required = false) Long carId,
                                                                           @RequestParam(required = false) Long garageId,
                                                                           @RequestParam(required = false) String startDate,
                                                                           @RequestParam(required = false) String endDate) {

    }

    @PostMapping
    public ResponseEntity<ResponseMaintenanceDto> createMaintenance(@RequestBody CreateMaintenanceDto createMaintenanceDTO) {

    }

    @GetMapping("/monthlyRequestsReport")
    public ResponseEntity<List<MonthlyRequestsReportDto>> monthlyRequestsReport(@RequestParam Long garageId,
                                                                                @RequestParam String startMonth,
                                                                                @RequestParam String endMonth) {

    }
}