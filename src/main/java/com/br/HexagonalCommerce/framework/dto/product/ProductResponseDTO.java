package com.br.HexagonalCommerce.framework.dto.product;

public record ProductResponseDTO(String name,
                                 int quantity,
                                 String order_uuid,
                                 float price) {
}
