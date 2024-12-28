package com.fmi_plovdiv.CarManagementApplication.dto;

import com.fmi_plovdiv.CarManagementApplication.model.Car;
import com.fmi_plovdiv.CarManagementApplication.model.Garage;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseCarDto {
    private Long id;
    private String make;
    private String model;
    private Integer productionYear;
    private String licensePlate;
    private List<ResponseGarageDto> garages;

    public static ResponseCarDto fromCar(Car car, List<Garage> garages) {
        ResponseCarDto dto = new ResponseCarDto();
        dto.id = car.getId();
        dto.make = car.getMake();
        dto.model = car.getModel();
        dto.productionYear = car.getProductionYear();
        dto.licensePlate = car.getLicensePlate();
        dto.garages = garages.stream()
                .map(ResponseGarageDto::fromGarage)
                .collect(Collectors.toList());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<ResponseGarageDto> getGarages() {
        return garages;
    }

    public void setGarages(List<ResponseGarageDto> garages) {
        this.garages = garages;
    }
}
