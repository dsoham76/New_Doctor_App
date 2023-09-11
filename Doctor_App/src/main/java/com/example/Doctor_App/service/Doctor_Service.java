package com.example.Doctor_App.service;

import com.example.Doctor_App.model.Doctor;
import com.example.Doctor_App.model.Patient;
import com.example.Doctor_App.model.enums.Symptoms;
import com.example.Doctor_App.repository.Doctor_Repo;
import com.example.Doctor_App.repository.Patient_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Doctor_Service {
    @Autowired
    Doctor_Repo doctorRepository;

    @Autowired
    Patient_Repo patientRepository;


    public List<Doctor> suggestDoctors(Integer patientId) {
        // Retrieve patient details by patientId
        Patient patient = patientRepository.getReferenceById(patientId);

        List<Doctor> suggestedDoctors=new ArrayList<>();

        String city=patient.getCity();

        if(patient==null){
            return Collections.singletonList(new Doctor("No patient exists with given id."));
        }
        if(city.equals("Delhi") || city.equals("Noida") || city.equals("Faridabad")){
            String symptoms=patient.getSymptoms().toString();
            String speciality=null;
            if(symptoms.equals("Arthritis") || symptoms.equals("Back_Pain") || symptoms.equals("Tissue_injuries"))
                speciality="Orthopedic";
            else if(symptoms.equals("Dysmenorrhea"))
                speciality="Gynecology";
            else if(symptoms.equals("Skin_infection") || symptoms.equals("Skin_burn"))
                speciality="Dermatology";
            else if(symptoms.equals("Ear_pain"))
                speciality="ENT_specialist";
            else
                return Collections.singletonList(new Doctor("No suitable doctor found for the given symptoms."));

            for(Doctor doctor: doctorRepository.findAll()){
                if(doctor.getSpecility().toString().equals(speciality)){
                    suggestedDoctors.add(doctor);
                }
            }
            return suggestedDoctors;
        }

        else{
            return Collections.singletonList(new Doctor("We are still waiting to expand to your location"));
        }

    }
}
