package com.example.clinifyauthorization.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.Area}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreaDto extends BaseDto {
    Integer id;
    CityDto city;
    String name;
//    Set<ClinicDto> clinics;
}
