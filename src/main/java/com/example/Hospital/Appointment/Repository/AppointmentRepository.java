package com.example.Hospital.Appointment.Repository;

import com.example.Hospital.Appointment.Entity.Appointment;
import com.example.Hospital.Appointment.Entity.PatientUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    //Method to find user
    List<Appointment> findByPatientUser(PatientUser patientUser);
}