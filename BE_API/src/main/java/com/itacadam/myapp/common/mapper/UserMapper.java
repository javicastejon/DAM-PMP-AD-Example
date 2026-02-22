package com.itacadam.myapp.common.mapper;


import org.springframework.stereotype.Component;

import com.itacadam.myapp.domain.models.User;
import com.itacadam.myapp.infrastructure.persistence.entity.UserEntity;
import com.itacadam.myapp.presentation.dto.request.UserRequest;
import com.itacadam.myapp.presentation.dto.response.UserResponse;

/**
 * Clase de mapeo para User, encargada de convertir entre diferentes representaciones de User (DTO, dominio, entidad).
 */
@Component
public class UserMapper {

    //#region Mapeos desde API hasta BD (DTO <-> Dominio <-> Entidad)

    // DTO a Dominio
    public User toDomain(UserRequest request) {
        return new User(
            null,
            request.nombre(),
            request.contrasena(),
            request.edad(),
            request.administrador()
        );
    }

    // Dominio a Entidad
    public UserEntity toEntity(User user) {
        return new UserEntity(
            null,
            user.getNombre(),
            user.getContrasena(),
            user.getEdad(),
            user.isAdministrador()
        );
    }
    //#endregion


    //#region Mapeos desde BD hasta API (Entidad <-> Dominio <-> DTO)
    // Entidad a Dominio
    public User toDomain(UserEntity entity) {
        return new User(
            entity.getId(),
            entity.getNombre(),
            entity.getContrasena(),
            entity.getEdad(),
            entity.isAdministrador()
        );
    }

    // Dominio a DTO
    public UserResponse toResponse(User user) {
        return new UserResponse(
            user.getId(),
            user.getNombre(),
            user.getContrasena(),
            user.getEdad(),
            user.isAdministrador()
        );
    }
    //#endregion
}
