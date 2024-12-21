package com.fmi_plovdiv.CarManagementApplication.model;

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

    public List<Garage> getGarages() {
        return garageIds;
    }

    public void setGarages(List<Garage> garages) {
        this.garageIds = garages;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
