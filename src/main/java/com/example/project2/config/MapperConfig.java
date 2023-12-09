package com.example.project2.config;

import com.example.project2.dto.PermissionDTO;
import com.example.project2.dto.UserDTO;
import com.example.project2.mapper.UserMapper;
import com.example.project2.model.Permission;
import com.example.project2.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MapperConfig {
    @Bean
    public UserMapper userMapper() {
        return new UserMapper() {
            @Override
            public UserDTO toDto(User user) {
                if (user == null) {
                    return null;
                }

                UserDTO userDTO = new UserDTO();

                userDTO.setId(user.getId());
                userDTO.setEmail(user.getEmail());
                userDTO.setPassword(user.getPassword());
                userDTO.setFullName(user.getFullName());
                userDTO.setPermissions(permissionListToPermissionDTOList(user.getPermissions()));

                return userDTO;
            }

            @Override
            public User toModel(UserDTO userDTO) {
                if (userDTO == null) {
                    return null;
                }

                User user = new User();

                user.setId(userDTO.getId());
                user.setEmail(userDTO.getEmail());
                user.setPassword(userDTO.getPassword());
                user.setFullName(userDTO.getFullName());
                user.setPermissions(permissionDTOListToPermissionList(userDTO.getPermissions()));

                return user;
            }

            @Override
            public List<UserDTO> toDtoList(List<User> userList) {
                if (userList == null) {
                    return null;
                }

                List<UserDTO> list = new ArrayList<UserDTO>(userList.size());
                for (User user : userList) {
                    list.add(toDto(user));
                }

                return list;
            }

            @Override
            public List<User> toModelList(List<UserDTO> userDTOList) {
                if (userDTOList == null) {
                    return null;
                }

                List<User> list = new ArrayList<User>(userDTOList.size());
                for (UserDTO userDTO : userDTOList) {
                    list.add(toModel(userDTO));
                }

                return list;
            }

            protected PermissionDTO permissionToPermissionDTO(Permission permission) {
                if (permission == null) {
                    return null;
                }

                PermissionDTO permissionDTO = new PermissionDTO();

                permissionDTO.setId(permission.getId());
                permissionDTO.setRole(permission.getRole());

                return permissionDTO;
            }

            protected List<PermissionDTO> permissionListToPermissionDTOList(List<Permission> list) {
                if (list == null) {
                    return null;
                }

                List<PermissionDTO> list1 = new ArrayList<PermissionDTO>(list.size());
                for (Permission permission : list) {
                    list1.add(permissionToPermissionDTO(permission));
                }

                return list1;
            }

            protected Permission permissionDTOToPermission(PermissionDTO permissionDTO) {
                if (permissionDTO == null) {
                    return null;
                }

                Permission permission = new Permission();

                permission.setId(permissionDTO.getId());
                permission.setRole(permissionDTO.getRole());

                return permission;
            }

            protected List<Permission> permissionDTOListToPermissionList(List<PermissionDTO> list) {
                if (list == null) {
                    return null;
                }

                List<Permission> list1 = new ArrayList<Permission>(list.size());
                for (PermissionDTO permissionDTO : list) {
                    list1.add(permissionDTOToPermission(permissionDTO));
                }

                return list1;
            }
        };
    }
}
