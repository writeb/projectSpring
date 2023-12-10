package com.example.project2.service;

import com.example.project2.dto.PermissionDTO;
import com.example.project2.dto.UserDTO;
import com.example.project2.mapper.PermissionMapper;
import com.example.project2.mapper.UserMapper;
import com.example.project2.model.User;
import com.example.project2.repository.PermissionRepository;
import com.example.project2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserMethodsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final PermissionMapper permissionMapper;
    private final PermissionRepository permissionRepository;

    public UserDTO addUser(UserDTO user){
        if (userRepository.findByEmail(user.getEmail()) == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            UserDTO newUser = userMapper.toDto(userRepository.save(userMapper.toModel(user)));
            changeUserRole(newUser.getId(), Long.valueOf(1));
            return newUser;
        }
        return null;
    }

    public void changeUserRole(Long userId, Long roleId){
        UserDTO user = userMapper.toDto(userRepository.findById(userId).orElse(null));
        if (user!=null){
            List<PermissionDTO> permissions = permissionMapper.toDtoList(permissionRepository.findPermissionsById(roleId));
            user.setPermissions(permissions);
            userMapper.toDto(userRepository.save(userMapper.toModel(user)));
        }
    }

    public UserDTO getUserById(Long id){
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }

    public void deleteUser(Long id){
        User deleteUser = userRepository.findUserById(id);

        if (deleteUser!=null){
            userRepository.deleteById(id);
        }

    }

    public UserDTO updateUser(Long id, UserDTO userDTO){
        User updatedUser = userRepository.findUserById(id);
        updatedUser.setEmail(userDTO.getEmail());
        updatedUser.setFullName(userDTO.getFullName());
//        updatedUser.setPermissions(userDTO.getPermissions());
        updatedUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userMapper.toDto(userRepository.save(updatedUser));
    }

//    public UserDTO getUserInfo(){
//        return getCurrentSessionUser();
//    }
//
//    public UserDTO getCurrentSessionUser(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof AnonymousAuthenticationToken)){
//            User user = (User) authentication.getPrincipal();
//            UserDTO userDTO = userMapper.toDto(user);
//            if (userDTO!=null){
//                return userDTO;
//            }
//        }
//        return null;
//    }
}
