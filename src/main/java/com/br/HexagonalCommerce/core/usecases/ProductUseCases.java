package com.br.HexagonalCommerce.core.usecases;

import com.br.HexagonalCommerce.core.entities.ProductEntity;
import com.br.HexagonalCommerce.core.exceptions.ProductNotFound;

public interface ProductUseCases {
    void create(ProductEntity product);
    void deleteById(Long id) throws ProductNotFound;
    boolean existsById(Long id) throws ProductNotFound;
    ProductEntity findById(Long id) throws ProductNotFound;

}
