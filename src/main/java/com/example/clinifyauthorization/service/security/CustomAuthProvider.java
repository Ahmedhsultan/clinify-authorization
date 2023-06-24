package com.example.clinifyauthorization.service.security;

import com.example.clinifyauthorization.service.security.user.clinic.ClinicUserDetailsService;
import com.example.clinifyauthorization.service.security.user.patient.PatientUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private ClinicUserDetailsService clinicUserDetailsService;
    @Autowired
    private PatientUserDetailsService patientUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        DaoAuthenticationProvider authenticationProvider;
        Authentication result;

        try {
            authenticationProvider = new DaoAuthenticationProvider();
            authenticationProvider.setPasswordEncoder(passwordEncoder);
            authenticationProvider.setUserDetailsService(clinicUserDetailsService);

            result = authenticationProvider.authenticate(authentication);
        } catch ( Exception ex) {
            try {
                authenticationProvider = new DaoAuthenticationProvider();
                authenticationProvider.setPasswordEncoder(passwordEncoder);
                authenticationProvider.setUserDetailsService(patientUserDetailsService);

                result = authenticationProvider.authenticate(authentication);
            } catch (InternalAuthenticationServiceException | AccountStatusException var14) {
                throw var14;
            } catch (AuthenticationException var15) {
                throw var15;
            }
        }
        return result;
    }

    @Override
    public boolean supports (Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
