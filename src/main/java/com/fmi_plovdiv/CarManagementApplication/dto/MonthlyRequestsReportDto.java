package com.fmi_plovdiv.CarManagementApplication.dto;

import java.time.YearMonth;

public class MonthlyRequestsReportDto {
    private YearMonth yearMonth;
    private Integer requests;

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Integer getRequests() {
        return requests;
    }

    public void setRequests(Integer requests) {
        this.requests = requests;
    }
}
