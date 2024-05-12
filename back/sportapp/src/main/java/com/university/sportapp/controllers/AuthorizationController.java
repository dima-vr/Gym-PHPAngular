package com.university.sportapp.controllers;

import com.university.sportapp.dto.converter.UserConverter;
import com.university.sportapp.dto.request.AuthorizationRequest;
import com.university.sportapp.dto.request.UserRequest;
import com.university.sportapp.dto.response.AuthorizationResponse;
import com.university.sportapp.models.Token;
import com.university.sportapp.models.User;
import com.university.sportapp.security.jwt.JwtService;
import com.university.sportapp.services.AuthorizationService;
import com.university.sportapp.services.TokenService;
import com.university.sportapp.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {
    private final UserService userService;
    private final AuthorizationService authorizationService;
    private final TokenService tokenService;
    private final JwtService jwtService;
    private final UserConverter userConverter;

    public AuthorizationController(
            UserService userService,
            AuthorizationService authorizationService,
            TokenService tokenService,
            JwtService jwtService,
            UserConverter userConverter) {
        this.userService = userService;
        this.authorizationService = authorizationService;
        this.tokenService = tokenService;
        this.jwtService = jwtService;
        this.userConverter = userConverter;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthorizationResponse> login(@RequestBody AuthorizationRequest request) {
        User user = userService.findByUsername(request.getUsername());
        if (user != null && authorizationService.validatePasswords(request.getPassword(), user.getPassword())) {
            AuthorizationResponse response = new AuthorizationResponse();
            response.setToken(jwtService.generateToken(request.getUsername()));
            response.setRefreshToken(tokenService.createRefreshToken());
            response.setAccessTokenLifetimeMinutes(jwtService.jwtExpirationMinutes);
            response.setRefreshTokenLifetimeMinutes(jwtService.refreshTokenExpirationMinutes);
            response.setUser(userConverter.entityToDto(user));

            Token token = tokenService.findByUser(user).orElse(new Token());
            token.setUser(user);
            token.setRefreshToken(response.getRefreshToken());
            token.setExpired(LocalDateTime.now().plusMinutes(jwtService.refreshTokenExpirationMinutes));
            tokenService.update(token);

            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/refresh")
    public ResponseEntity<Object> refreshToken(@RequestParam @NotEmpty String refreshToken) {
        Token token = tokenService.findByRefreshToken(refreshToken);
        if (tokenService.validateRefreshToken(token)) {
            AuthorizationResponse response = new AuthorizationResponse();
            response.setToken(jwtService.generateToken(token.getUser().getEmail()));
            response.setRefreshToken(tokenService.createRefreshToken());
            response.setAccessTokenLifetimeMinutes(jwtService.jwtExpirationMinutes);
            response.setRefreshTokenLifetimeMinutes(jwtService.refreshTokenExpirationMinutes);
            response.setUser(userConverter.entityToDto(token.getUser()));

            token.setRefreshToken(response.getRefreshToken());
            token.setExpired(LocalDateTime.now().plusMinutes(jwtService.refreshTokenExpirationMinutes));
            tokenService.update(token);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        tokenService.delete(tokenService.findByRefreshToken(refreshToken).getId());
        return new ResponseEntity<>("token timed out", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/authenticate")
    public ResponseEntity<Object> getUserFromToken(HttpServletRequest servletRequest) {
        String token = jwtService.getTokenFromRequest(servletRequest);
        String email = jwtService.getUsernameFromToken(token);
        User user = userService.findByUsername(email);
        return new ResponseEntity<>(userConverter.entityToDto(user), HttpStatus.OK);
    }

    @PostMapping("/logout")
    public void logout(@RequestParam @NotEmpty String refreshToken) {
        tokenService.delete(tokenService.findByRefreshToken(refreshToken).getId());
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRequest request) {
        User user = userConverter.dtoToEntity(request);

        try {
            if (userService.findByUsername(request.getUsername()) == null) {
                return new ResponseEntity<>("error", HttpStatus.CONFLICT);
            } else {
                user = userService.create(user);
            }
        } catch (NoSuchElementException noSuchElementException) {
            try {
                user = userService.create(user);
                return new ResponseEntity<>(user, HttpStatus.CREATED);
            } catch (Exception e) {
                user = userService.create(user);
            }
        }


        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}