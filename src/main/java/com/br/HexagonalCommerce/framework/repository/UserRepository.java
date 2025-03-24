package com.br.HexagonalCommerce.framework.repository;

import com.br.HexagonalCommerce.framework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
