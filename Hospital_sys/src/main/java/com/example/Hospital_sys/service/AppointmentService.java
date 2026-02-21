package com.example.Hospital_sys.service;

import com.example.Hospital_sys.entity.*;
import com.example.Hospital_sys.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Appointment book(Appointment appointment) {

        // 🔥 Fetch real patient from DB
        Patient patient = patientRepository.findById(
                appointment.getPatient().getId()
        ).orElseThrow(() -> new RuntimeException("Patient not found"));

        // 🔥 Fetch real doctor from DB
        Doctor doctor = doctorRepository.findById(
                appointment.getDoctor().getId()
        ).orElseThrow(() -> new RuntimeException("Doctor not found"));

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getTodayAppointments() {
        LocalDate today = LocalDate.now();
        return appointmentRepository.findByAppointmentDateTimeBetween(
                today.atStartOfDay(),
                today.atTime(23, 59, 59)
        );
    }
}