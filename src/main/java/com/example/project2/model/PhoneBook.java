package com.example.project2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "t_phonebooks")
@Getter
@Setter
public class PhoneBook {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String phone_number;
    private String email;
    private LocalDate b_day;
    private String organization;

    @ManyToOne
    private User user;
}
