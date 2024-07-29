package com.example.Hospital.Appointment.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "medicine_Management")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serialNo;

    private String medicineId;
    private String medicineName;
    private String Dosage;
    private int quantity;

    //Getter and Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="patient_User_Id",referencedColumnName = "id")
    private PatientUser patientUser;


    //Default Constructor
    public Medicine(){

    }

    //Constructor
    public Medicine(int serialNo, String medicineId, String medicineName, String dosage, int quantity) {
        this.serialNo = serialNo;
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        Dosage = dosage;
        this.quantity = quantity;
    }
}