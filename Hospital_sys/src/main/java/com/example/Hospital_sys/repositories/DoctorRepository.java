package com.example.Hospital_sys.repositories;



import com.example.Hospital_sys.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
