package com.example.project2.controller;

import com.example.project2.dto.UserDTO;
import com.example.project2.service.UserMethodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserMethodsService userMethodsService;

    @GetMapping(value = "/{id}")
    public UserDTO getUserById(@PathVariable(name = "id") Long id){
        return userMethodsService.getUserById(id);
    }

    @PostMapping
    public UserDTO signUp(@RequestBody UserDTO userDTO){
        return userMethodsService.addUser(userDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable(name = "id") Long id){
        userMethodsService.deleteUser(id);
    }

    @PutMapping(value = "/{id}")
    public UserDTO updateUser(@PathVariable(name = "id") Long id,
                              @RequestBody UserDTO userDTO){
        return userMethodsService.updateUser(id, userDTO);
    }



}
