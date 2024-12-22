package com.fmi_plovdiv.CarManagementApplication.controller;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateGarageDto;
import com.fmi_plovdiv.CarManagementApplication.dto.GarageDailyAvailabilityReportDto;
import com.fmi_plovdiv.CarManagementApplication.dto.ResponseGarageDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateGarageDto;
import com.fmi_plovdiv.CarManagementApplication.service.GarageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garages")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseGarageDto> getGarageById(@PathVariable Long id) {
        ResponseGarageDto responseGarageDto = garageService.getById(id);
        return ResponseEntity.ok(responseGarageDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseGarageDto> updateGarage(@PathVariable Long id, @RequestBody UpdateGarageDto updateGarageDTO) {
        ResponseGarageDto responseGarageDto = garageService.update(id, updateGarageDTO);
        return ResponseEntity.ok(responseGarageDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarageById(@PathVariable Long id) {
        garageService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ResponseGarageDto>> getAllGarages(@RequestParam(required = false) String city) {
        List<ResponseGarageDto> responseGarageDtosList = garageService.getAll();
        return ResponseEntity.ok(responseGarageDtosList);
    }

    @PostMapping
    public ResponseEntity<ResponseGarageDto> createGarage(@RequestBody CreateGarageDto createGarageDTO) {
        ResponseGarageDto responseGarageDto = garageService.create(createGarageDTO);
        return ResponseEntity.ok(responseGarageDto);
    }

    @GetMapping("/dailyAvailabilityReport")
    public ResponseEntity<List<GarageDailyAvailabilityReportDto>> getGarageReport(@RequestParam Long garageId,
                                                                                  @RequestParam String startDate,
                                                                                  @RequestParam String endDate) {
        List<GarageDailyAvailabilityReportDto> availabilityReports = garageService.getReport(garageId, startDate, endDate);
        return ResponseEntity.ok(availabilityReports);
    }
}