package com.example.clinifyauthorization.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Patient}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto extends BaseDto {

    Integer id;
    AreaDto area;
    CityDto city;
    String phoneNumber;
    String fullName;
    String email;
    Date birthDate;
    String gender;
    String address;
    Integer preperationTime;
    Boolean isDeleted;
//    Set<PatientDocumentDto> patientDocuments;
//    Set<AppointmentDto> appointments;

}
