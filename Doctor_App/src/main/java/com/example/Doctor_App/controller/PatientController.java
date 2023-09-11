package com.example.Doctor_App.controller;


import com.example.Doctor_App.model.Doctor;
import com.example.Doctor_App.model.Patient;
import com.example.Doctor_App.repository.Patient_Repo;
import com.example.Doctor_App.service.Doctor_Service;
import com.example.Doctor_App.service.Patient_Service;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class PatientController {


    @Autowired
    private Patient_Service patient_service;

    @Autowired
    private Doctor_Service doctor_service;

    // Endpoint to add a patient
    @PostMapping("patient")
    public String addPatient(@RequestBody Patient patient) {
        return patient_service.savePatient(patient);
    }

    // Endpoint to remove a patient by ID
    @DeleteMapping("patient/{id}")
    public ResponseEntity<Void> removePatient(@PathVariable Integer id) {
        patient_service.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("patient/{patient_id}")
    public List<Doctor> getDoctors(@PathVariable Integer patient_id){
        return doctor_service.suggestDoctors(patient_id);
    }


}
