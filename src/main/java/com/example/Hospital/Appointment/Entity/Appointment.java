package com.example.Hospital.Appointment.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Entity
@Table(name = "Appointments")
public class Appointment {

    //Getter and setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    private String appointmentSlots;

    @Getter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patient_User_Id",referencedColumnName = "id")
    private PatientUser patientUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id",referencedColumnName = "doctor_id")
    private Doctor doctorDetails;
    @Getter
    private String medicalHistory;
    @Getter
    private String date;

    //Default Constructor
    public Appointment() {

    }

    //Constructor
    public Appointment(int id, String appointmentSlots, Doctor doctorDetails, String medicalHistory, String date) {
        this.id = id;
        this.appointmentSlots = appointmentSlots;
        this.doctorDetails = doctorDetails;
        this.medicalHistory = medicalHistory;
        this.date = date;
    }

    // Getter and Setter for doctorDetails
    public Doctor getDoctorDetails(Doctor doctor) {
        return doctorDetails;
    }

}