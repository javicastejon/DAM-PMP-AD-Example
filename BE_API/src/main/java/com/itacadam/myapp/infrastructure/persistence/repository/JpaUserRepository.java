package com.itacadam.myapp.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itacadam.myapp.infrastructure.persistence.entity.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> { 
}
