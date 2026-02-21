package com.example.Hospital_sys.service;

import com.example.Hospital_sys.entity.Appointment;
import com.example.Hospital_sys.entity.Consultation;
import com.example.Hospital_sys.repositories.AppointmentRepository;
import com.example.Hospital_sys.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository repository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Consultation save(Long appointmentId, Consultation consultation) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow();
        appointment.setCompleted(true);
        consultation.setAppointment(appointment);
        return repository.save(consultation);
    }

    public List<Consultation> getByPatient(Long patientId) {
        return repository.findByAppointment_Patient_Id(patientId);
    }
}
