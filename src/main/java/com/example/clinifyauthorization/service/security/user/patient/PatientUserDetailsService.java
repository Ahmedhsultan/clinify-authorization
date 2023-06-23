package com.example.clinifyauthorization.service.security.user.patient;

import com.example.clinifyauthorization.persistence.entity.Patient;
import com.example.clinifyauthorization.persistence.reposatory.ClinicRepository;
import com.example.clinifyauthorization.persistence.reposatory.PatientRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PatientUserDetailsService implements UserDetailsService {
    private PatientRepository patientRepository;

    public PatientUserDetailsService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Patient> optionalPatient;

        if (isEmail(username)) {
            optionalPatient = patientRepository.findByEmailIgnoreCase(username);
        } else if (isPhoneNumber(username)) {
            optionalPatient = patientRepository.findByPhoneNumber(username);
        }else{
            throw new UsernameNotFoundException(":(");
        }

        Patient patient = optionalPatient.orElseThrow(() -> new UsernameNotFoundException(":("));
        var patientAuthorities = List.of(new SimpleGrantedAuthority("PATIENT"));

        return new User(username, patient.getPassword(), patientAuthorities);
    }

    private static boolean isEmail(String input) {
        // Regular expression pattern for email validation
        String emailPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }

    private static boolean isPhoneNumber(String input) {
        // Regular expression pattern for phone number validation
        String phonePattern = "\\d{11}";

        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
