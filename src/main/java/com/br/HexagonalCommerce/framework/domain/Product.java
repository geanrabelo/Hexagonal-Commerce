package com.br.HexagonalCommerce.framework.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "tb_product")
@Entity(name = "product")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Product {

    public Product(Long id, String name, int quantity, float price, Order order) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public Product(String name, int quantity, float price, Order order){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_name")
    private String name;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_uuid")
    private Order order;

    private float price;
}
