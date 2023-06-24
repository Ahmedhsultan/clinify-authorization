package com.example.clinifyauthorization.persistence.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDocumentDto extends BaseDto {
    Integer id;
    Date date;
    String documentUrl;
    String description;
}