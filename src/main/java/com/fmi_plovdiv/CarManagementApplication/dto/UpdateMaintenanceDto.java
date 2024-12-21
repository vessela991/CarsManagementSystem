package com.fmi_plovdiv.CarManagementApplication.dto;

public class UpdateMaintenanceDto {
    private Long carId;
    private String serviceType;
    private String scheduledDate;
    private Long garageId;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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

    public Long getGarageId() {
        return garageId;
    }

    public void setGarageId(Long garageId) {
        this.garageId = garageId;
    }
}

