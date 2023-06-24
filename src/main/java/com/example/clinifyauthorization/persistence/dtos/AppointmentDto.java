package com.example.clinifyauthorization.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto extends BaseDto {
    Integer id;
    DoctorDto doctor;
    PatientDto patient;
    Timestamp date;
    Time startTime;
    Time endTime;
    String creditCardLastFourDigits;
    String status;
    Integer rating;
    String description;
}
