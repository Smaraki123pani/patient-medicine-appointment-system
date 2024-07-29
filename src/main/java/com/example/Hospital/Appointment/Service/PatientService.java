package com.example.Hospital.Appointment.Service;

import com.example.Hospital.Appointment.Controller.Dto.PatientRegistrationDto;
import com.example.Hospital.Appointment.Entity.PatientUser;

public interface PatientService {

    //Method to Save patient using DTO
    PatientUser save(PatientRegistrationDto registrationDto);

}