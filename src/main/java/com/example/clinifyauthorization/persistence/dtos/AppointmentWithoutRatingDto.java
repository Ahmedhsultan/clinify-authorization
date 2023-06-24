package com.example.clinifyauthorization.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Appointment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppointmentWithoutRatingDto extends BaseDto {
    Integer id;
    DoctorDto doctor;
    PatientDto patient;
    Timestamp date;
    Time startTime;
    Time endTime;
    String creditCardLastFourDigits;
}
