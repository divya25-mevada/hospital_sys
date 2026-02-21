package com.example.Hospital_sys.repositories;

import com.example.Hospital_sys.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNameContainingIgnoreCaseOrPhoneContaining(String name, String phone);
}
