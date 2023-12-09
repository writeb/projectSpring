package com.example.project2.dto;

import com.example.project2.model.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PhoneBookDTO {
    private String id;
    private String name;
    private String phone_number;
    private String email;
    private LocalDate b_day;
    private String organization;
}
