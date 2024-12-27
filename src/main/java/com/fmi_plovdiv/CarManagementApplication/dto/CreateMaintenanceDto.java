package com.fmi_plovdiv.CarManagementApplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateMaintenanceDto {
    @NotNull(message = "Car Id is mandatory")
    private Long carId;
    @NotNull(message = "Garage Id is mandatory")
    private Long garageId;
    @NotBlank(message = "Service type is mandatory")
    private String serviceType;
    @NotBlank(message = "Schedule date is mandatory")
    private String scheduledDate;

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
}
