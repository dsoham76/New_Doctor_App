package com.example.Doctor_App.repository;

import com.example.Doctor_App.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Patient_Repo extends JpaRepository<Patient,Integer> {


}
