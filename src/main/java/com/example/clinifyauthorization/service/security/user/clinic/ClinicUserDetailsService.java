package com.example.clinifyauthorization.service.security.user.clinic;

import com.example.clinifyauthorization.persistence.entity.Clinic;
import com.example.clinifyauthorization.persistence.reposatory.ClinicRepository;
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
public class ClinicUserDetailsService implements UserDetailsService {
    private ClinicRepository clinicRepository;

    public ClinicUserDetailsService(ClinicRepository clinicRepository){
        this.clinicRepository = clinicRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Clinic> optionalClinic;

        if (isEmail(username)) {
            optionalClinic = clinicRepository.findByEmailIgnoreCase(username);
        } else if (isPhoneNumber(username)) {
            optionalClinic = clinicRepository.findByPhoneNumber(username);
        }else{
            throw new UsernameNotFoundException(":(");
        }

        Clinic clinic = optionalClinic.orElseThrow(() -> new UsernameNotFoundException(":("));
        var patientAuthorities = List.of(new SimpleGrantedAuthority("CLINIC"));

        return new User(clinic.getEmail(), clinic.getPassword(), patientAuthorities);
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
