package com.fmi_plovdiv.CarManagementApplication.dto;

public class GarageDailyAvailabilityReportDto {
    private String date;
    private Integer requests;
    private Integer availableCapacity;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getRequests() {
        return requests;
    }

    public void setRequests(Integer requests) {
        this.requests = requests;
    }

    public Integer getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(Integer availableCapacity) {
        this.availableCapacity = availableCapacity;
    }
}