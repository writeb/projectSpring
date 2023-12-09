package com.example.project2.mapper;

import com.example.project2.dto.PermissionDTO;
import com.example.project2.model.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionDTO toDto(Permission permission);

    Permission toModel(PermissionDTO permissionDTO);

    List<PermissionDTO> toDtoList(List<Permission> permissionList);
    List<Permission>  toModelList(List<PermissionDTO> permissionDTOList);
}

