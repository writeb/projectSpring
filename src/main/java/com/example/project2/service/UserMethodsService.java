package com.example.project2.service;

import com.example.project2.dto.UserDTO;
import com.example.project2.mapper.UserMapper;
import com.example.project2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMethodsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    public UserDTO addUser(UserDTO user){
        if (userRepository.findByEmail(user.getEmail()) == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            UserDTO newUser = userMapper.toDto(userRepository.save(userMapper.toModel(user)));
            return newUser;
        }
        return null;
    }
}
