package com.example.clinifyauthorization.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link gov.iti.jets.clinify.models.entities.City}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityDto extends BaseDto {
    Integer id;
    String name;
//    Set<AreaDto> areas;
}
