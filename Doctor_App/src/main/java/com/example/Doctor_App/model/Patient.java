package com.example.Doctor_App.model;

import com.example.Doctor_App.model.enums.Symptoms;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Min(value = 3)
    private String name;
    @Min(value =10)
    @Max(value=10)
    private String phone_Number;
    @Email(message = "Enter valid email id")
    private String email;
    @Max(value=20)
    private String city;
    private Symptoms symptoms;

}
