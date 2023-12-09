package com.example.project2.config;

import com.example.project2.dto.PhoneBookDTO;
import com.example.project2.mapper.PhoneBookMapper;
import com.example.project2.model.PhoneBook;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


public class PhoneBookMapperConfig {
    @Bean
    public PhoneBookMapper phoneBookMapper() {
        return new PhoneBookMapper() {
            @Override
            public PhoneBookDTO toDto(PhoneBook user) {
                if (user == null) {
                    return null;
                }

                PhoneBookDTO userDTO = new PhoneBookDTO();

                userDTO.setId(user.getId());
                userDTO.setEmail(user.getEmail());
                userDTO.setName(user.getName());
                userDTO.setPhone_number(user.getPhone_number());
                userDTO.setOrganization(user.getOrganization());
                userDTO.setB_day(user.getB_day());
                return userDTO;
            }

            @Override
            public PhoneBook toModel(PhoneBookDTO userDTO) {
                if (userDTO == null) {
                    return null;
                }

                PhoneBook user = new PhoneBook();

                user.setId(userDTO.getId());
                user.setEmail(userDTO.getEmail());
                user.setPhone_number(userDTO.getPhone_number());
                user.setOrganization(userDTO.getOrganization());
                user.setB_day(userDTO.getB_day());
                user.setName(userDTO.getName());

                return user;
            }

            @Override
            public List<PhoneBookDTO> toDtoList(List<PhoneBook> userList) {
                if (userList == null) {
                    return null;
                }

                List<PhoneBookDTO> list = new ArrayList<PhoneBookDTO>(userList.size());
                for (PhoneBook user : userList) {
                    list.add(toDto(user));
                }

                return list;
            }

            @Override
            public List<PhoneBook> toModelList(List<PhoneBookDTO> userDTOList) {
                if (userDTOList == null) {
                    return null;
                }

                List<PhoneBook> list = new ArrayList<>(userDTOList.size());
                for (PhoneBookDTO userDTO : userDTOList) {
                    list.add(toModel(userDTO));
                }

                return list;
            }
        };
    }
}
