package com.example.clinifyauthorization.controller;

import com.example.clinifyauthorization.persistence.dtos.*;
import com.example.clinifyauthorization.persistence.entity.BaseEntity;
import com.example.clinifyauthorization.persistence.entity.City;
import com.example.clinifyauthorization.persistence.entity.Clinic;
import com.example.clinifyauthorization.persistence.entity.Patient;
import com.example.clinifyauthorization.persistence.reposatory.ClinicRepository;
import com.example.clinifyauthorization.persistence.reposatory.PatientRepository;
import com.example.clinifyauthorization.util.mapper.ClinicMapper;
import com.example.clinifyauthorization.util.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ClinicRepository clinicRepository;

    @GetMapping("/userData")
    public ResponseEntity<BaseDto> getPatientProfile(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        String authority = userDetails.getAuthorities().stream().findFirst().get().getAuthority();

        if (authority.equals("PATIENT")){
            Patient patient = patientRepository.findByEmailIgnoreCase(username).get();
            PatientDto patientDto = PatientMapper.toDto(patient);

            return ResponseEntity.ok().body(patientDto);
        }
        else if (authority.equals("CLINIC")){
            Clinic clinic = clinicRepository.findByEmailIgnoreCase(username).get();
            ClinicDto clinicDto = ClinicMapper.toDto(clinic);

            return ResponseEntity.ok().body(clinicDto);
        }

        return ResponseEntity.badRequest().body(null);
    }

//    @GetMapping("test")
//    public String method() {
//        System.out.println("test");
//        return "ok";
//    }
    @GetMapping("success")
    public ResponseEntity success() {
        System.out.println("success");
        return ResponseEntity.ok().build();
    }
//    @GetMapping("fail")
//    public ResponseEntity fail() {
//        System.out.println("fail");
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//    }
//    @GetMapping("proccess")
//    public String proccess() {
//        System.out.println("proccess");
//        return "proccess";
//    }
}
