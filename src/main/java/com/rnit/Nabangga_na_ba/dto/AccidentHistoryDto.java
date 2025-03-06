package com.rnit.Nabangga_na_ba.dto;

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
    private String damageSeverity; // "Minor", "Moderate", "Severe"
    private String repairStatus; // "Repaired", "Pending", "Total Loss"
    private LocalDateTime reportedAt;
}