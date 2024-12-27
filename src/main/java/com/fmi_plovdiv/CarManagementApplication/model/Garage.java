package com.fmi_plovdiv.CarManagementApplication.model;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateGarageDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateGarageDto;
import jakarta.persistence.*;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    private String city;
    @Column(nullable = false)
    private Integer capacity;

    public static Garage fromUpdateGarageDto(Long id, UpdateGarageDto updateGarageDTO) {
        Garage garage = new Garage();
        garage.setId(id);
        garage.setName(updateGarageDTO.getName());
        garage.setLocation(updateGarageDTO.getLocation());
        garage.setCity(updateGarageDTO.getCity());
        garage.setCapacity(updateGarageDTO.getCapacity());
        return garage;
    }

    public static Garage fromCreateGarageDto(CreateGarageDto createGarageDTO) {
        Garage garage = new Garage();
        garage.setName(createGarageDTO.getName());
        garage.setLocation(createGarageDTO.getLocation());
        garage.setCapacity(createGarageDTO.getCapacity());
        return garage;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
