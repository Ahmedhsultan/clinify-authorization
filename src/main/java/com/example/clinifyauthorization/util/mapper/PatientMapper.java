package com.example.clinifyauthorization.util.mapper;

import com.example.clinifyauthorization.persistence.dtos.AreaDto;
import com.example.clinifyauthorization.persistence.dtos.CityDto;
import com.example.clinifyauthorization.persistence.dtos.PatientDto;
import com.example.clinifyauthorization.persistence.entity.Patient;

public class PatientMapper {
    public static PatientDto toDto(Patient patient){
        CityDto cityDto = CityDto.builder()
                .name(patient.getCity().getName())
                .id(patient.getCity().getId())
                .build();

        AreaDto areaDto = AreaDto.builder()
                .name(patient.getArea().getName())
                .id(patient.getArea().getId())
                .city(cityDto)
                .build();

        PatientDto patientDto = PatientDto.builder()
                .id(patient.getId())
                .address(patient.getAddress())
                .email(patient.getEmail())
                .city(cityDto)
                .area(areaDto)
                .gender(patient.getGender())
                .fullName(patient.getFullName())
                .birthDate(patient.getBirthDate())
                .preperationTime(patient.getPreperationTime())
                .isDeleted(patient.getIsDeleted())
                .build();

        return patientDto;
    }
}
