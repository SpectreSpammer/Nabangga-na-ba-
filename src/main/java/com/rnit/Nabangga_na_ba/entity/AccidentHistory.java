package com.rnit.Nabangga_na_ba.entity;

import com.rnit.Nabangga_na_ba.enums.DamageSeverity;
import com.rnit.Nabangga_na_ba.enums.RepairStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "accident_history")
public class AccidentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Cars car;

    @NotNull(message = "The accident date is required!")
    @PastOrPresent(message = "The accident date must be in the past or present!")
    @Column(nullable = false)
    private LocalDate accidentDate;

    @NotEmpty(message = "The location is required!")
    @Column(nullable = false)
    private String location;

    @NotEmpty(message = "The accident description is required!")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(nullable = false, length = 500)
    private String description;

    @NotNull(message = "The damage severity is required!")
    @Enumerated(EnumType.STRING) // Saves as a string in the database
    @Column(nullable = false)
    private DamageSeverity damageSeverity;

    @NotNull(message = "The repair status is required!")
    @Enumerated(EnumType.STRING) // Saves as a string in the database
    @Column(nullable = false)
    private RepairStatus repairStatus;

    @PastOrPresent(message = "Reported date must be in the past or present!")
    @Column(nullable = false, updatable = false)
    private LocalDate reportedAt = LocalDate.now();
}