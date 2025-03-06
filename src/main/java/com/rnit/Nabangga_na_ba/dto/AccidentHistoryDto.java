package com.rnit.Nabangga_na_ba.dto;

import com.rnit.Nabangga_na_ba.enums.DamageSeverity;
import com.rnit.Nabangga_na_ba.enums.RepairStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AccidentHistoryDto {

    private int id;
    private int carId;
    private LocalDate accidentDate;
    private String location;
    private String description;
    private DamageSeverity damageSeverity; // Enum, not String
    private RepairStatus repairStatus; // Enum, not String
    private LocalDate reportedAt; // Changed from LocalDateTime to LocalDate

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public LocalDate getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DamageSeverity getDamageSeverity() {
        return damageSeverity;
    }

    public void setDamageSeverity(DamageSeverity damageSeverity) {
        this.damageSeverity = damageSeverity;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(RepairStatus repairStatus) {
        this.repairStatus = repairStatus;
    }

    public LocalDate getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(LocalDate reportedAt) {
        this.reportedAt = reportedAt;
    }
}