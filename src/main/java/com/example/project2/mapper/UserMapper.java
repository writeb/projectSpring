package com.example.project2.mapper;

import com.example.project2.dto.UserDTO;
import com.example.project2.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    User toModel(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> userList);
    List<User>  toModelList(List<UserDTO> userDTOList);

}