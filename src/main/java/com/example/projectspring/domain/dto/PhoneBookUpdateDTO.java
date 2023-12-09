package com.example.projectspring.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBookUpdateDTO {
    public String name;
    public String email;
    public String phone_number;
    public String address;
    public LocalDate b_day;
    public String organization;
}
