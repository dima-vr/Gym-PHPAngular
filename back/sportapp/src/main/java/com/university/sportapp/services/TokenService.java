package com.university.sportapp.services;

import com.university.sportapp.dao.BaseDao;
import com.university.sportapp.dao.TokenDao;
import com.university.sportapp.models.Token;
import com.university.sportapp.models.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService extends BaseService<Token> {
    private final TokenDao tokenDao;

    public TokenService(BaseDao<Token> baseDao, TokenDao tokenDao) {
        super(baseDao);
        this.tokenDao = tokenDao;
    }

    public String createRefreshToken() {
        return UUID.randomUUID().toString();
    }

    public Token findByRefreshToken(String refreshToken) {
        return this.tokenDao.findByRefreshToken(refreshToken);
    }

    public Optional<Token> findByUser(User user) {
        return this.tokenDao.findByUser(user);
    }

    public boolean validateRefreshToken(Token token) {
        return (token != null && LocalDateTime.now().isBefore(token.getExpired()));
    }
}
