package com.itacadam.myapp.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.itacadam.myapp.common.mapper.UserMapper;
import com.itacadam.myapp.domain.models.User;
import com.itacadam.myapp.domain.repository.UserRepository;
import com.itacadam.myapp.infrastructure.persistence.repository.JpaUserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaRepository;
    private final UserMapper mapper;

    public UserRepositoryImpl(JpaUserRepository jpaRepository,
                              UserMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    public User save(User user) {
        return mapper.toDomain(
            jpaRepository.save(mapper.toEntity(user))
        );
    }

    public Optional<User> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    public List<User> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}