package com.itacadam.myapp.infrastructure.security;

import com.itacadam.myapp.domain.models.User;

public interface TokenGenerator {
    String generate(User user);
}
