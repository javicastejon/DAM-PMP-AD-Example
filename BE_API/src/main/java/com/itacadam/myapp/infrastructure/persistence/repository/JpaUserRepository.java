package com.itacadam.myapp.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itacadam.myapp.infrastructure.persistence.entity.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> { 
    @Query("SELECT u FROM UserEntity u WHERE u.nombre = :nombre")
    Optional<UserEntity> findUserByName(String nombre);
}
