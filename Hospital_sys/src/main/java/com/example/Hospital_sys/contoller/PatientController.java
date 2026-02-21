package com.example.Hospital_sys.contoller;

import com.example.Hospital_sys.entity.Patient;
import com.example.Hospital_sys.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public Patient add(@RequestBody Patient patient) {
        return service.save(patient);
    }

    @GetMapping
    public List<Patient> list() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<Patient> search(@RequestParam String keyword) {
        return service.search(keyword);
    }
}