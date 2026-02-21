package com.example.Hospital_sys.contoller;


import com.example.Hospital_sys.entity.Consultation;
import com.example.Hospital_sys.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultations")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultationController {

    @Autowired

    private ConsultationService service;

    // ✅ Add Consultation to Appointment
    @PostMapping("/{appointmentId}")
    public Consultation addConsultation(
            @PathVariable  Long appointmentId,
            @RequestBody Consultation consultation) {

        return service.save(appointmentId, consultation);
    }

    // ✅ Get Completed Consultations by Patient
    @GetMapping("/patient/{patientId}")
    public List<Consultation> getByPatient(@PathVariable Long patientId) {
        return service.getByPatient(patientId);
    }
}
