package com.example.Hospital_sys.repositories;

import com.example.Hospital_sys.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByAppointment_Patient_Id(Long patientId);
}