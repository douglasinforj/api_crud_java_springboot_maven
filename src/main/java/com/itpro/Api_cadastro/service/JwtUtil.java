package com.itpro.Api_cadastro.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "secretsecretsecretsecretsecretsecretsecretsecret"; // Pelo menos 32 caracteres
    private static final long EXPIRATION_TIME = 86400000; // 1 dia

    // Converte a chave para SecretKey
    private final SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", username); 
        claims.put("iat", new Date()); 
        claims.put("exp", new Date(System.currentTimeMillis() + EXPIRATION_TIME)); 

        return Jwts.builder()
                .claims(claims) 
                .signWith(key, Jwts.SIG.HS256) 
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(key) 
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("sub", String.class); 
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .verifyWith(key) // Agora recebe um SecretKey
                .build()
                .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
