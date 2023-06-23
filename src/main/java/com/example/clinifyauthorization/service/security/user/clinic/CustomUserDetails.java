package com.example.clinifyauthorization.service.security.user.clinic;

import com.example.clinifyauthorization.persistence.entity.Clinic;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final Clinic clinic;
    private final String userName;

    public CustomUserDetails(Clinic clinic, String userName) {
        this.clinic = clinic;
        this.userName = userName;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("clinic"));
    }

    @Override
    public String getPassword() {
        return clinic.getPassword();
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
