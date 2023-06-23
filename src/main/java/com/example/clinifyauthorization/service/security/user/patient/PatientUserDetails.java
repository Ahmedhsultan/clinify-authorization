package com.example.clinifyauthorization.service.security.user.patient;

import com.example.clinifyauthorization.persistence.entity.Patient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class PatientUserDetails implements UserDetails {
    private final Patient patient;
    private final String userName;

    public PatientUserDetails(Patient patient, String userName) {
        this.patient = patient;
        this.userName = userName;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("patient"));
    }

    @Override
    public String getPassword() {
        return patient.getPassword();
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
