package com.example.Doctor_App.repository;

import com.example.Doctor_App.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Doctor_Repo extends JpaRepository<Doctor,Integer> {
}
