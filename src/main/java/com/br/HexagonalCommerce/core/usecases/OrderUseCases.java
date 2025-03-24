package com.br.HexagonalCommerce.core.usecases;

import com.br.HexagonalCommerce.core.entities.OrderEntity;
import com.br.HexagonalCommerce.core.entities.UserEntity;
import com.br.HexagonalCommerce.core.exceptions.OrderNotFound;

import java.util.UUID;

public interface OrderUseCases {

    UUID create(UserEntity user);
    void deleteById(UUID id) throws OrderNotFound;
    boolean existsById(UUID id) throws OrderNotFound;
    OrderEntity findById(UUID id) throws OrderNotFound;

}
