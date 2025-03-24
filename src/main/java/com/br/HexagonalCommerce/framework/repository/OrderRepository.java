package com.br.HexagonalCommerce.framework.repository;

import com.br.HexagonalCommerce.framework.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
