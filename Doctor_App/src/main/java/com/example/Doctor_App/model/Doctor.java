package com.example.Doctor_App.model;

import com.example.Doctor_App.model.enums.Specility;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {
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
    @NotBlank
    private String password;
    @Max(value=20)
    private String city;
    private Specility specility;

    private String response=null;

    public Doctor(String s) {
        this.response=s;
    }
}
