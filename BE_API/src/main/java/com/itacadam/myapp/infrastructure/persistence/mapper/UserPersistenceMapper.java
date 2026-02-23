package com.itacadam.myapp.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;

import com.itacadam.myapp.domain.models.User;
import com.itacadam.myapp.infrastructure.persistence.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

    // Domain → Entity
    UserEntity toEntity(User user);

    // Entity → Domain
    User toDomain(UserEntity entity);
}
