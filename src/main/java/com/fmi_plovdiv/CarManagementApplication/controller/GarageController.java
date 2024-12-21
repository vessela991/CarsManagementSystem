package com.fmi_plovdiv.CarManagementApplication.controller;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateGarageDto;
import com.fmi_plovdiv.CarManagementApplication.dto.GarageDailyAvailabilityReportDto;
import com.fmi_plovdiv.CarManagementApplication.dto.ResponseGarageDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateGarageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garages")
public class GarageController {

    @GetMapping("/{id}")
    public ResponseEntity<ResponseGarageDto> getGarageById(@PathVariable Long id) {

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseGarageDto> updateGarage(@PathVariable Long id, @RequestBody UpdateGarageDto updateGarageDTO) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarageById(@PathVariable Long id) {

    }

    @GetMapping
    public ResponseEntity<List<ResponseGarageDto>> getAllGarages(@RequestParam(required = false) String city) {

    }

    @PostMapping
    public ResponseEntity<ResponseGarageDto> createGarage(@RequestBody CreateGarageDto createGarageDTO) {

    }

    @GetMapping("/dailyAvailabilityReport")
    public ResponseEntity<List<GarageDailyAvailabilityReportDto>> getGarageReport(@RequestParam Long garageId,
                                                                                  @RequestParam String startDate,
                                                                                  @RequestParam String endDate) {

    }
}