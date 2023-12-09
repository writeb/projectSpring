package com.example.projectspring.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "phone_book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBook {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "b_day")
    private LocalDate b_day;

    @Column(name = "organization")
    private String organization;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
