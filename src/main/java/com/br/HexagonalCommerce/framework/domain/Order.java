package com.br.HexagonalCommerce.framework.domain;

import com.br.HexagonalCommerce.core.entities.OrderEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "order")
@Table(name = "tb_order")
@Data
@EqualsAndHashCode(of = "uuid")
@NoArgsConstructor
public class Order {

    public Order(User user){
        this.user = user;
    }

    public Order(OrderEntity orderEntity, User user){
        this.uuid = orderEntity.getId();
        this.user = user;
        this.price = orderEntity.getPrice();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private float price;

    @OneToMany(mappedBy = "order")
    private List<Product> productList;
}
