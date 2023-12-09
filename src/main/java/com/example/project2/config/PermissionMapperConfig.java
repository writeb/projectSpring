package com.example.project2.config;

import com.example.project2.dto.PermissionDTO;
import com.example.project2.mapper.PermissionMapper;
import com.example.project2.model.Permission;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class PermissionMapperConfig {

    @Bean
    public PermissionMapper permissionMapper() {
        return new PermissionMapper() {
            @Override
            public PermissionDTO toDto(Permission permission) {
                if ( permission == null ) {
                    return null;
                }

                PermissionDTO permissionDTO = new PermissionDTO();

                permissionDTO.setId( permission.getId() );
                permissionDTO.setRole( permission.getRole() );

                return permissionDTO;
            }

            @Override
            public Permission toModel(PermissionDTO permissionDTO) {
                if ( permissionDTO == null ) {
                    return null;
                }

                Permission permission = new Permission();

                permission.setId( permissionDTO.getId() );
                permission.setRole( permissionDTO.getRole() );

                return permission;
            }

            @Override
            public List<PermissionDTO> toDtoList(List<Permission> permissionList) {
                if ( permissionList == null ) {
                    return null;
                }

                List<PermissionDTO> list = new ArrayList<PermissionDTO>( permissionList.size() );
                for ( Permission permission : permissionList ) {
                    list.add( toDto( permission ) );
                }

                return list;
            }

            @Override
            public List<Permission> toModelList(List<PermissionDTO> permissionDTOList) {
                if ( permissionDTOList == null ) {
                    return null;
                }

                List<Permission> list = new ArrayList<Permission>( permissionDTOList.size() );
                for ( PermissionDTO permissionDTO : permissionDTOList ) {
                    list.add( toModel( permissionDTO ) );
                }

                return list;
            }
        };
    }


}
