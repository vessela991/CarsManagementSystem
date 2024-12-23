package com.fmi_plovdiv.CarManagementApplication.dto;

import com.fmi_plovdiv.CarManagementApplication.model.Maintenance;

public class ResponseMaintenanceDto {
    private Long id;
    private Long carId;
    private String carName;
    private String serviceType;
    private String scheduledDate;
    private Long garageId;
    private String garageName;

    public static ResponseMaintenanceDto fromMaintenance(Maintenance maintenance, String carName, String garageName) {
        ResponseMaintenanceDto dto = new ResponseMaintenanceDto();
        dto.setId(maintenance.getId());
        dto.setCarId(maintenance.getCarId());
        dto.setCarName(carName);
        dto.setServiceType(maintenance.getServiceType());
        dto.setScheduledDate(maintenance.getScheduledDate());
        dto.setGarageId(maintenance.getGarageId());
        dto.setGarageName(garageName);
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
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

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }
}
