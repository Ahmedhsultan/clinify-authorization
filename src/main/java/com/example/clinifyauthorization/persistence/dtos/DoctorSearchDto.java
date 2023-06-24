package com.example.clinifyauthorization.persistence.dtos;

import com.example.clinifyauthorization.persistence.entity.Area;
import com.example.clinifyauthorization.persistence.entity.City;
import com.example.clinifyauthorization.persistence.entity.DoctorSpecialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSearchDto {
    private DoctorSpecialization specialization;
    private City city;
    private Area area;
    private String clinicName;
}
