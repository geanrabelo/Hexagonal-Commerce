package com.br.HexagonalCommerce.framework.repository;

import com.br.HexagonalCommerce.framework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

}
