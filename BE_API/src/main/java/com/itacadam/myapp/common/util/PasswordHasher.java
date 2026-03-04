package com.itacadam.myapp.common.util;

public interface PasswordHasher {
    String hash(String raw);
    boolean matches(String raw, String encoded);
}