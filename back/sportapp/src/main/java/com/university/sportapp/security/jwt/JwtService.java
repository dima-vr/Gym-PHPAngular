package com.university.sportapp.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static com.university.sportapp.security.jwt.JwtFilter.AUTHORIZATION;
import static org.springframework.util.StringUtils.hasText;

@Service
@Log
public class JwtService {

    @Value("${com.university.sportapp.jwt.jwtSecret}")
    private String jwtSecret;

    @Value("${com.university.sportapp.jwt.jwtExpirationMinutes}")
    public int jwtExpirationMinutes;

    @Value("${com.university.sportapp.jwt.refreshExpirationMinutes}")
    public int refreshTokenExpirationMinutes;


    public String generateToken(String username) {
        LocalDateTime expirationDateTime = LocalDateTime.now().plusMinutes(jwtExpirationMinutes);
        Date expirationDate = Date.from(expirationDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}
