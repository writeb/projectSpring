package com.example.project2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private String id;
    private String email;
    private String password;
    private String fullName;
    private List<PermissionDTO> permissions;
}
