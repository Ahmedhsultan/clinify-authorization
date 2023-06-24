package com.example.clinifyauthorization.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Clinic}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClinicDto extends BaseDto {
    Integer id;
    AreaDto area;
    CityDto city;
    String username;
    String password;
    String name;
    String phoneNumber;
    String email;
    String address;
    String status;
    Boolean isDeleted;
//    Set<DoctorDto> doctors;
}
