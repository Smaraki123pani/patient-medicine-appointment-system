package com.example.Hospital.Appointment.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "PatientUser",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class PatientUser {

    //Getter and Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_Name")
    private String firstName;
    @Column(name="last_Name")
    private String lastName;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Collection<PatientRole> roles;


    //Default Constructor
    public PatientUser(){

    }
    //Constructor
    public PatientUser(String firstName, String lastName, String email, String password, Collection<PatientRole> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}