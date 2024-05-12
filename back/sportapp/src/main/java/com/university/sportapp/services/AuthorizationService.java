package com.university.sportapp.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final PasswordEncoder passwordEncoder;

    public AuthorizationService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public boolean validatePasswords(String password1, String password2) {
        return passwordEncoder.matches(password1, password2);
    }
}
