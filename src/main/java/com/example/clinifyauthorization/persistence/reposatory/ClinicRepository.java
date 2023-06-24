package com.example.clinifyauthorization.persistence.reposatory;

import com.example.clinifyauthorization.persistence.entity.Clinic;

import java.util.Optional;

public interface ClinicRepository extends BaseRepository<Clinic> {
    public Clinic findByEmailIgnoreCaseAndPassword(String email, String password);
    Optional<Clinic> findByEmailIgnoreCase(String email);
    Optional<Clinic> findByPhoneNumber(String phoneNumber);
}
