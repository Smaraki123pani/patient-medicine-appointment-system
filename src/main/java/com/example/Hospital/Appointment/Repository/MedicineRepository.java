package com.example.Hospital.Appointment.Repository;

import com.example.Hospital.Appointment.Entity.Medicine;
import com.example.Hospital.Appointment.Entity.PatientUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

    //Method to find patient Serial No
    Optional<Medicine> findById(Integer serialNo);

    //Method to find user in medicine section
    List<Medicine> findByPatientUser(PatientUser patientUser);
}