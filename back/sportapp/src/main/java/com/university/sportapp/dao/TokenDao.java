package com.university.sportapp.dao;

import com.university.sportapp.models.Token;
import com.university.sportapp.models.User;
import com.university.sportapp.repositories.TokenRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TokenDao extends BaseDao<Token> {
    public TokenDao(JpaRepository<Token, Long> repository) {
        super(repository);
    }

    public Optional<Token> findByUser(User user) {
        Optional<Token> optionalUser = ((TokenRepository) repository).findByUser(user);
        return optionalUser;
    }

    public Token findByRefreshToken(String refreshToken) {
        Optional<Token> optionalUser = ((TokenRepository) repository).findByRefreshToken(refreshToken);
        return optionalUser.orElse(null);
    }
}
