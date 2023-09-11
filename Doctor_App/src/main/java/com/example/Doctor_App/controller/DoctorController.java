package com.example.Doctor_App.controller;

import com.example.Doctor_App.model.Doctor;
import com.example.Doctor_App.repository.Doctor_Repo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    private Doctor_Repo doctorRepository;

    // Endpoint to add a doctor
    @PostMapping("doctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Endpoint to remove a doctor by ID
    @DeleteMapping("/doctor/{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable Integer id) {
        doctorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

