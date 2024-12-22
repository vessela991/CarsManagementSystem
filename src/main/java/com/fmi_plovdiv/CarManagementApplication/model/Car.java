package com.fmi_plovdiv.CarManagementApplication.model;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateCarDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateCarDto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private Integer productionYear;
    private String licensePlate;
    @ElementCollection
    @CollectionTable(name = "car_garage_ids", joinColumns = @JoinColumn(name = "car_id"))
    @Column(name = "garage_id")
    private List<Long> garageIds;

    public static Car fromUpdateCarDto(Long id, UpdateCarDto updateCarDTO) {
        Car car = new Car();
        car.setId(id);
        car.setMake(updateCarDTO.getMake());
        car.setModel(updateCarDTO.getModel());
        car.setProductionYear(updateCarDTO.getProductionYear());
        car.setLicensePlate(updateCarDTO.getLicensePlate());
        car.setGarageIds(updateCarDTO.getGarageIds());
        return car;
    }

    public static Car fromCreateCarDto(CreateCarDto createCarDTO) {
        Car car = new Car();
        car.setMake(createCarDTO.getMake());
        car.setModel(createCarDTO.getModel());
        car.setProductionYear(createCarDTO.getProductionYear());
        car.setLicensePlate(createCarDTO.getLicensePlate());
        car.setGarageIds(createCarDTO.getGarageIds());
        return car;
    }

    public List<Long> getGarageIds() {
        return garageIds;
    }

    public void setGarageIds(List<Long> garageIds) {
        this.garageIds = garageIds;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
