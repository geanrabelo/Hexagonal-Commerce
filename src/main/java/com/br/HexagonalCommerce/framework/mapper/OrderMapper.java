package com.br.HexagonalCommerce.framework.mapper;


import com.br.HexagonalCommerce.core.entities.OrderEntity;
import com.br.HexagonalCommerce.framework.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    @Lazy
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    public OrderEntity toOrderEntity(Order order){
        var listProductentity = productMapper.toListProductEntity(order.getProductList());

        return new OrderEntity(
                userMapper.toUserEntity(order.getUser()));
    }

    public Order toOrder(OrderEntity orderEntity){
        return new Order(
                userMapper.toUser(orderEntity.getUser()));
    }

    public Order toOrderAll(OrderEntity orderEntity){
        var user = userMapper.toUserWithId(orderEntity.getUser());
        return new Order(orderEntity, user);
    }

    public OrderEntity toOrderEntityAll(Order order){
        var userEntity = userMapper.toUserEntityWithId(order.getUser());
        return new OrderEntity(order.getUuid(), userEntity, order.getPrice());
    }
}
