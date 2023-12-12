package com.example.project2.controller;

import com.example.project2.dto.UserDTO;
import com.example.project2.model.AuthenticationResponse;
import com.example.project2.model.User;
import com.example.project2.service.UserMethodsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "User Methods")
public class UserController {

    private final UserMethodsService userMethodsService;

    @Operation(summary = "Get All users method")
    @GetMapping(value = "all-users")
    public List<UserDTO> getAllUsers(){
        return userMethodsService.getUsers();
    }

    @Operation(summary = "Get user by ID method")
    @GetMapping(value = "/{id}")
    public UserDTO getUserById(@PathVariable(name = "id") Long id){
        return userMethodsService.getUserById(id);
    }

    @Operation(summary = "Add user method")
    @PostMapping(value = "/register")
    public AuthenticationResponse signUp(@RequestBody UserDTO userDTO){
        return userMethodsService.addUser(userDTO);
    }

    @Operation(summary = "Delete user by ID method")
    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable(name = "id") Long id){
        userMethodsService.deleteUser(id);
    }

    @Operation(summary = "Update user by ID method")
    @PutMapping(value = "/{id}")
    public UserDTO updateUser(@PathVariable(name = "id") Long id,
                              @RequestBody UserDTO userDTO){
        return userMethodsService.updateUser(id, userDTO);
    }

    @Operation(summary = "Get user PAGINATION method")
    @GetMapping(value = "/all")
    public Page<User> getAll(@RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "10") int size){
        return userMethodsService.getAllUserEntries(page, size);
    }

}
