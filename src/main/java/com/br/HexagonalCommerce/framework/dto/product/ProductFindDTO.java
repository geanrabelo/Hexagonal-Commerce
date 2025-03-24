package com.br.HexagonalCommerce.framework.dto.product;

import com.br.HexagonalCommerce.core.entities.ProductEntity;

import java.util.UUID;

public record ProductFindDTO(Long id,
                             String name,
                             int quantity,
                             UUID order_uuid,
                             float price) {
    public ProductFindDTO(ProductEntity productEntity){
        this(productEntity.getId(),
                productEntity.getName(),
                productEntity.getQuantity(),
                productEntity.getOrder().getId(),
                productEntity.getPrice());
    }
}
