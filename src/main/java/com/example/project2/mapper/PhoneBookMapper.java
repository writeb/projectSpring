package com.example.project2.mapper;

import com.example.project2.dto.PhoneBookDTO;
import com.example.project2.model.PhoneBook;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneBookMapper {
    PhoneBookDTO toDto(PhoneBook phoneBook);

    PhoneBook toModel(PhoneBookDTO phoneBookDTO);

    List<PhoneBookDTO> toDtoList(List<PhoneBook> phoneBooks);
    List<PhoneBook>  toModelList(List<PhoneBookDTO> phoneBookDTOS);
}
