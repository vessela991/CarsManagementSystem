package com.fmi_plovdiv.CarManagementApplication.model;

import com.fmi_plovdiv.CarManagementApplication.dto.CreateMaintenanceDto;
import com.fmi_plovdiv.CarManagementApplication.dto.UpdateMaintenanceDto;
import jakarta.persistence.*;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long carId;
    @Column(nullable = false)
    private Long garageId;
    @Column(nullable = false)
    private String serviceType;
    @Column(nullable = false)
    private String scheduledDate;

    public static Maintenance fromUpdateMaintenanceDto(Long id, UpdateMaintenanceDto updateMaintenanceDTO) {
        Maintenance maintenance = new Maintenance();
        maintenance.setId(id);
        maintenance.setCarId(updateMaintenanceDTO.getCarId());
        maintenance.setGarageId(updateMaintenanceDTO.getGarageId());
        maintenance.setServiceType(updateMaintenanceDTO.getServiceType());
        maintenance.setScheduledDate(updateMaintenanceDTO.getScheduledDate());
        return maintenance;
    }

    public static Maintenance fromCreateMaintenanceDto(CreateMaintenanceDto createMaintenanceDTO) {
        Maintenance maintenance = new Maintenance();
        maintenance.setCarId(createMaintenanceDTO.getCarId());
        maintenance.setGarageId(createMaintenanceDTO.getGarageId());
        maintenance.setServiceType(createMaintenanceDTO.getServiceType());
        maintenance.setScheduledDate(createMaintenanceDTO.getScheduledDate());
        return maintenance;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getGarageId() {
        return garageId;
    }

    public void setGarageId(Long garageId) {
        this.garageId = garageId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
