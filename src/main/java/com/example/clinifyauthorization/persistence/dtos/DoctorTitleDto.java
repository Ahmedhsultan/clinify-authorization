package com.example.clinifyauthorization.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.DoctorTitle}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorTitleDto extends BaseDto {
     Integer id;
     String name;
//    Set<DoctorDto> doctors;
}
