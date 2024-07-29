package com.example.Hospital.Appointment.Repository;

import com.example.Hospital.Appointment.Entity.PatientUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<PatientUser,Long> {

    //Method to find patient by Email
    PatientUser findByEmail(String email);

    //Method to find user by their userId
    Optional<PatientUser> findById(long id);
}