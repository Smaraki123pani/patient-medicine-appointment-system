package com.example.Hospital.Appointment.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "PatientRole")
public class PatientRole {

    //Getter and Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    //Default Constructor
    public PatientRole(){

    }
    public PatientRole(String name) {
        this.name = name;
    }


}