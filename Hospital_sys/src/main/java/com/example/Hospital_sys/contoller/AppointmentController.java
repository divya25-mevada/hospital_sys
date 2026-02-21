package com.example.Hospital_sys.contoller;


import com.example.Hospital_sys.entity.Appointment;
import com.example.Hospital_sys.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    // ✅ Book Appointment
    @PostMapping
    public Appointment book(@RequestBody Appointment appointment) {
        return service.book(appointment);
    }

    // ✅ Get Today's Appointments
    @GetMapping("/today")
    public List<Appointment> getToday() {
        return service.getTodayAppointments();
    }
}