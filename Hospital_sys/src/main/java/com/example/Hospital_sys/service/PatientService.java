package com.example.Hospital_sys.service;

import com.example.Hospital_sys.entity.Patient;
import com.example.Hospital_sys.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    public List<Patient> getAll() {
        return repository.findAll();
    }

    public List<Patient> search(String keyword) {
        return repository
                .findByNameContainingIgnoreCaseOrPhoneContaining(keyword, keyword);
    }
}