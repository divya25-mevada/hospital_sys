    package com.example.Hospital_sys.entity;

    import jakarta.persistence.*;
    import lombok.Data;

    @Entity
    @Data
    public class Consultation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String bloodPressure;
        private Double temperature;
        private String notes;
        private boolean completed;

        @OneToOne
        @JoinColumn(name = "appointment_id")
        private Appointment appointment;
    }