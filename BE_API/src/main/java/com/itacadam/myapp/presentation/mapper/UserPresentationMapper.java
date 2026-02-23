package com.itacadam.myapp.presentation.mapper;

import org.mapstruct.Mapper;

import com.itacadam.myapp.domain.models.User;
import com.itacadam.myapp.presentation.dto.request.UserRequest;
import com.itacadam.myapp.presentation.dto.response.UserResponse;

@Mapper(componentModel = "spring")
public interface UserPresentationMapper {

    // Request → Domain
    User toDomain(UserRequest request);

    // Domain → Response
    UserResponse toResponse(User user);
}
