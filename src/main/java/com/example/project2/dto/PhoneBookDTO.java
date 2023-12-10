package com.example.project2.dto;
import com.example.project2.model.User;

import java.time.LocalDate;

public class PhoneBookDTO {

    private Long id;
    private String name;
    private String phone_number;
    private String email;
    private LocalDate b_day;
    private String organization;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getB_day() {
        return b_day;
    }

    public void setB_day(LocalDate b_day) {
        this.b_day = b_day;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
