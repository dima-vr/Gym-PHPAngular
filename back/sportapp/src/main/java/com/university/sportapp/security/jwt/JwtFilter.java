package com.university.sportapp.security.jwt;

import com.university.sportapp.security.CustomUserDetails;
import com.university.sportapp.models.User;
import com.university.sportapp.services.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Log
@Component
public class JwtFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION = "Authorization";

    private final JwtService jwtService;

    @Autowired
    private final UserService userService;

    public JwtFilter(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtService.getTokenFromRequest(request);
        if (token != null) {
            try {
                String username = jwtService.getUsernameFromToken(token);
                User user = userService.findByUsername(username);
                CustomUserDetails customUserDetails = new CustomUserDetails(user);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (ExpiredJwtException e) {
                log.severe("ExpiredJwtException :" + e);
            }
        }
        filterChain.doFilter(request, response);
    }


}
