package com.example.clinifyauthorization.util.mapper;

import com.example.clinifyauthorization.persistence.dtos.AreaDto;
import com.example.clinifyauthorization.persistence.dtos.CityDto;
import com.example.clinifyauthorization.persistence.dtos.ClinicDto;
import com.example.clinifyauthorization.persistence.entity.Clinic;

public class ClinicMapper {
    public static ClinicDto toDto(Clinic clinic){
        CityDto cityDto = CityDto.builder()
                .name(clinic.getCity().getName())
                .id(clinic.getCity().getId())
                .build();

        AreaDto areaDto = AreaDto.builder()
                .name(clinic.getArea().getName())
                .id(clinic.getArea().getId())
                .city(cityDto)
                .build();

        ClinicDto clinicDto = ClinicDto.builder()
                .id(clinic.getId())
                .address(clinic.getAddress())
                .email(clinic.getEmail())
                .city(cityDto)
                .area(areaDto)
                .password(clinic.getPassword())
                .isDeleted(clinic.getIsDeleted())
                .phoneNumber(clinic.getPhoneNumber())
                .status(clinic.getStatus())
                .username(clinic.getUsername())
                .name(clinic.getName())
                .build();

        return clinicDto;
    }
}
