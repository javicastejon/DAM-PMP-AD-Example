package com.itacadam.myapp.common.mapper;


import org.springframework.stereotype.Component;

import com.itacadam.myapp.domain.models.User;
import com.itacadam.myapp.infrastructure.persistence.entity.UserEntity;
import com.itacadam.myapp.presentation.dto.request.UserRequest;
import com.itacadam.myapp.presentation.dto.response.UserResponse;

@Component
public class UserMapper {

    public User toDomain(UserRequest request) {
        return new User(
            null,
            request.nombre(),
            request.contrasena(),
            request.edad(),
            request.administrador()
        );
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
            user.getId(),
            user.getNombre(),
            user.getContrasena(),
            user.getEdad(),
            user.isAdministrador()
        );
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(
            null,
            user.getNombre(),
            user.getContrasena(),
            user.getEdad(),
            user.isAdministrador()
        );
    }

    public User toDomain(UserEntity entity) {
        return new User(
            entity.getId(),
            entity.getNombre(),
            entity.getContrasena(),
            entity.getEdad(),
            entity.isAdministrador()
        );
    }
}
