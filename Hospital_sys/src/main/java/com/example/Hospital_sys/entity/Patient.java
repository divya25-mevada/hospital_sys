package com.example.Hospital_sys.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private Integer age;
    private String phone;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}