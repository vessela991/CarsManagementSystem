package com.fmi_plovdiv.CarManagementApplication.dto;

import com.fmi_plovdiv.CarManagementApplication.model.Garage;

public class ResponseGarageDto {
    private Long id;
    private String name;
    private String location;
    private String city;
    private Integer capacity;

    public static ResponseGarageDto fromGarage(Garage garage) {
        ResponseGarageDto responseGarageDto = new ResponseGarageDto();
        responseGarageDto.setId(garage.getId());
        responseGarageDto.setName(garage.getName());
        responseGarageDto.setLocation(garage.getLocation());
        responseGarageDto.setCity(garage.getCity());
        responseGarageDto.setCapacity(garage.getCapacity());
        return responseGarageDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

