package com.example.demo.Service;

public interface JwtService {
    
    String generateToken(String user);

    String getUsernameFromToken(String token);

    boolean validateToken(String token);
}
