package com.itacadam.myapp.infrastructure.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.itacadam.myapp.common.util.TokenGenerator;
import com.itacadam.myapp.domain.models.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenGenerator implements TokenGenerator {

    private final String SECRET = "super_secret_key_super_secret_key";

    @Override
    public String generate(User user) {
        return Jwts.builder()
                .setSubject(user.getNombre())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }
}
