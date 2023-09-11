package com.example.Doctor_App.service;



import com.example.Doctor_App.model.Patient;
import com.example.Doctor_App.repository.Doctor_Repo;
import com.example.Doctor_App.repository.Patient_Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Patient_Service {
    @Autowired
    Patient_Repo patientRepo;

    @Autowired
    Doctor_Repo doctorRepo;


    public String savePatient(Patient patient) {
        patientRepo.save(patient);
        return "Patient has been added.";
    }

    public void deletePatient(Integer id) {
        patientRepo.deleteById(id);
    }
}
