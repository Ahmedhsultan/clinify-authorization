package com.example.clinifyauthorization.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Doctor}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto extends BaseDto {

    Integer id;
    DoctorTitleDto doctorTitle;
    ClinicDto clinic;
    DoctorSpecializationDto doctorSpecialization;
    String fullName;
    String phoneNumber;
    int ticketPrice;
    Double averageRating;
    Integer ratingCount;
    String status;
//    Set<AppointmentWithoutRatingDto> appointments;
}
