package com.br.HexagonalCommerce.framework.dto.product;


import com.br.HexagonalCommerce.framework.domain.Product;

public record ProductCreatedDTO(String name,
                                int quantity,
                                String order_uuid,
                                float price) {

    public ProductCreatedDTO(Product product){
        this(product.getName(), product.getQuantity(), String.valueOf(product.getOrder().getUuid()), product.getPrice());
    }

}
