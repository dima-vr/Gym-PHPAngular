package com.university.sportapp.repositories;

import com.university.sportapp.models.Token;
import com.university.sportapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByRefreshToken(String refreshToken);

    Optional<Token> findByUser(User user);
}
