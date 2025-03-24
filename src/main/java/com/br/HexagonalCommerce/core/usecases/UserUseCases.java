package com.br.HexagonalCommerce.core.usecases;

import com.br.HexagonalCommerce.core.entities.UserEntity;
import com.br.HexagonalCommerce.core.enums.Roles;
import com.br.HexagonalCommerce.core.exceptions.UserNotFound;

public interface UserUseCases {
    void create(String name, String password, Roles roles);
    void deleteById(Long id) throws UserNotFound;
    boolean existsById(Long id) throws UserNotFound;
    UserEntity findById(Long id) throws UserNotFound;
}
