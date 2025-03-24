package com.br.HexagonalCommerce.core.entities;

import java.util.List;
import java.util.UUID;

public class OrderEntity {

    private UUID id;
    private UserEntity user;
    private float price;
    private List<ProductEntity> productEntityList;

    public OrderEntity(UserEntity userEntity) {
        this.user = userEntity;
    }

    public OrderEntity(UUID id, UserEntity user, float price) {
        this.id = id;
        this.user = user;
        this.price = price;
    }

    public List<ProductEntity> getProductEntityList() {
        return productEntityList;
    }

    public void setProductEntityList(List<ProductEntity> productEntityList) {
        this.productEntityList = productEntityList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
