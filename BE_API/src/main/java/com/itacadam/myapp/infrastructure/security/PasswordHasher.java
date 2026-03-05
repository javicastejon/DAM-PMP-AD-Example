package com.itacadam.myapp.infrastructure.security;

public interface PasswordHasher {
    String hash(String raw);
    boolean matches(String raw, String encoded);
}