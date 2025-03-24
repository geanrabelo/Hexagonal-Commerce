package com.br.HexagonalCommerce.framework.repository;

import com.br.HexagonalCommerce.framework.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
