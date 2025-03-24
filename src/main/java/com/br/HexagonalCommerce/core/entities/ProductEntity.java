package com.br.HexagonalCommerce.core.entities;

public class ProductEntity {

    private Long id;
    private String name;
    private int quantity;
    private float price;
    private OrderEntity order;

    public ProductEntity(Long id, String name, int quantity, float price, OrderEntity order) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public ProductEntity(String name, int quantity, float price, OrderEntity orderEntity) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.order = orderEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
