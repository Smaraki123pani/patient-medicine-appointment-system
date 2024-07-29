package com.example.Hospital.Appointment.Controller.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientRegistrationDto {

    //Getter and Setter
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    //Default Constructor
    public PatientRegistrationDto(){

    }

    //Constructor
    public PatientRegistrationDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

}