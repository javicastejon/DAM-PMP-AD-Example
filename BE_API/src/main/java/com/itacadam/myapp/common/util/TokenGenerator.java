package com.itacadam.myapp.common.util;

import com.itacadam.myapp.domain.models.User;

public interface TokenGenerator {
    String generate(User user);
}
