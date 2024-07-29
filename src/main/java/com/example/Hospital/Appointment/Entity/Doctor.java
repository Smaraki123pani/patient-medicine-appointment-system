package com.example.Hospital.Appointment.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Doctor_Details")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_Id")
    private int doctorId;
    @Column(name = "DoctorName")
    private String name;
    private String specialization;
    private String qualification;
    private int experience;
    //Getter and Setter
    private double consultationFee;
    private String availableSlot;
    private String availableDate;
    private String availableTime;

    // Default constructor
    public Doctor() {

    }

    //Constructor
    public Doctor(int doctorId, String name, String specialization, String qualification, int experience,
                  double consultationFee, String availableSlot,String availableDate, String availableTime) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experience = experience;
        this.consultationFee = consultationFee;
        this.availableSlot = availableSlot;
        this.availableDate = availableDate;
        this.availableTime = availableTime;

    }
}