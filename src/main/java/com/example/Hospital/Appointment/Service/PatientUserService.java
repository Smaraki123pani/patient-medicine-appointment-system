package com.example.Hospital.Appointment.Service;

import com.example.Hospital.Appointment.Controller.Dto.PatientRegistrationDto;
import com.example.Hospital.Appointment.Entity.PatientRole;
import com.example.Hospital.Appointment.Entity.PatientUser;
import com.example.Hospital.Appointment.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientUserService implements PatientService, UserDetailsService {


    //Repositories using Constructor Injection Below
    private final PatientRepository patientRepository;

    //Implement password encoder and using constructor Injection Below
    private PasswordEncoder passwordEncoder;

    //using Constructor Injection for Patient Repository
    @Autowired
    public PatientUserService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //Using constructor injection for password encoder
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //Method to save database
    @Override
    public PatientUser save(PatientRegistrationDto registrationDto) {
        String encodedPassword = passwordEncoder.encode(registrationDto.getPassword());
        PatientUser patientUser = new PatientUser(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                encodedPassword,
                List.of(new PatientRole("ROLE_USER"))
        );
        return patientRepository.save(patientUser);
    }

    //Method to save patientId into Appointment
    public PatientUser getById(long id){
        return  patientRepository.findById(id).orElse(null);
    }

    //Method retrieve from database
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PatientUser user = patientRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password " +
                    "OR If you don't Have an account Please click Register here...!");
        }
        return new User(
                user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<PatientRole> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    //Method to check current Logger
    public PatientUser getCurrentlyLoggedInPatientUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return patientRepository.findByEmail(email);
    }
}