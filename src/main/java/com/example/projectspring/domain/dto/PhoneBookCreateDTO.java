package com.example.projectspring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhoneBookCreateDTO {
    public String name;
    public String phone_number;
    public String email;
    public String address;
    public LocalDate b_day;
    public String organization;
    public String user_id;
}
