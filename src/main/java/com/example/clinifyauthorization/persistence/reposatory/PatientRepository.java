package com.example.clinifyauthorization.persistence.reposatory;


import com.example.clinifyauthorization.persistence.entity.Clinic;
import com.example.clinifyauthorization.persistence.entity.Patient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PatientRepository extends BaseRepository<Patient> {
    Patient findByEmailIgnoreCaseAndPassword(String email, String password);
    Optional<Patient> findByEmailIgnoreCase(String email);
    Optional<Patient> findByPhoneNumber(String phoneNumber);
}
