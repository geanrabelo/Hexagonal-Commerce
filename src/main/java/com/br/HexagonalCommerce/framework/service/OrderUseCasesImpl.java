package com.br.HexagonalCommerce.framework.service;

import com.br.HexagonalCommerce.core.entities.OrderEntity;
import com.br.HexagonalCommerce.core.entities.UserEntity;
import com.br.HexagonalCommerce.core.exceptions.OrderNotFound;
import com.br.HexagonalCommerce.core.usecases.OrderUseCases;
import com.br.HexagonalCommerce.framework.domain.Order;
import com.br.HexagonalCommerce.framework.mapper.OrderMapper;
import com.br.HexagonalCommerce.framework.mapper.UserMapper;
import com.br.HexagonalCommerce.framework.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderUseCasesImpl implements OrderUseCases {

    private final OrderRepository orderRepository;

    private final UserMapper userMapper;

    private final OrderMapper orderMapper;


    public OrderUseCasesImpl(OrderRepository orderRepository, UserMapper userMapper, OrderMapper orderMapper){
        this.orderRepository = orderRepository;
        this.userMapper = userMapper;
        this.orderMapper = orderMapper;
    }
    @Override
    public UUID create(UserEntity userEntity) {
        var user = userMapper.toUserWithId(userEntity);
        var order = new Order(user);
        orderRepository.save(order);

        return orderRepository.getReferenceById(order.getUuid()).getUuid();
    }

    @Override
    public void deleteById(UUID id) throws OrderNotFound {
        if(existsById(id)){
            orderRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(UUID id) throws OrderNotFound {
        if(!orderRepository.existsById(id)){
            throw new OrderNotFound("Order searched by id not found");
        }else{
            return true;
        }
    }

    @Override
    public OrderEntity findById(UUID id) throws OrderNotFound {
        if(existsById(id)){
            Order order = orderRepository.getReferenceById(id);
            return orderMapper.toOrderEntityAll(order);
        }else{
            return null;
        }
    }
}
