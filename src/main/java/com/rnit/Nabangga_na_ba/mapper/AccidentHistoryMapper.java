package com.rnit.Nabangga_na_ba.mapper;

import com.rnit.Nabangga_na_ba.dto.AccidentHistoryDto;
import com.rnit.Nabangga_na_ba.entity.AccidentHistory;
import com.rnit.Nabangga_na_ba.entity.Cars;
import com.rnit.Nabangga_na_ba.enums.DamageSeverity;
import com.rnit.Nabangga_na_ba.enums.RepairStatus;

public class AccidentHistoryMapper {

    public static AccidentHistoryDto toDto(AccidentHistory accident) {
        AccidentHistoryDto dto = new AccidentHistoryDto();
        dto.setId(accident.getId());
        dto.setCarId(accident.getCar().getId());
        dto.setAccidentDate(accident.getAccidentDate());
        dto.setLocation(accident.getLocation());
        dto.setDescription(accident.getDescription());

        // Assign Enums directly since DTO now expects Enum type
        dto.setDamageSeverity(accident.getDamageSeverity());
        dto.setRepairStatus(accident.getRepairStatus());

        // No conversion needed, both are LocalDate
        dto.setReportedAt(accident.getReportedAt());

        return dto;
    }

    public static AccidentHistory toEntity(AccidentHistoryDto dto, Cars car) {
        AccidentHistory accident = new AccidentHistory();
        accident.setCar(car);
        accident.setAccidentDate(dto.getAccidentDate());
        accident.setLocation(dto.getLocation());
        accident.setDescription(dto.getDescription());

        // Assign Enums directly
        accident.setDamageSeverity(dto.getDamageSeverity());
        accident.setRepairStatus(dto.getRepairStatus());

        // No conversion needed, both are LocalDate
        accident.setReportedAt(dto.getReportedAt());

        return accident;
    }
}
