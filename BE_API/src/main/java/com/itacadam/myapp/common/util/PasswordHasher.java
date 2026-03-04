package com.itacadam.myapp.common.util;

public interface PasswordHasher {
    boolean matches(String raw, String encoded);
}