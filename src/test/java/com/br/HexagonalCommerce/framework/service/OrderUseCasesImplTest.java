package com.br.HexagonalCommerce.framework.service;

import com.br.HexagonalCommerce.core.entities.UserEntity;
import com.br.HexagonalCommerce.core.enums.Roles;
import com.br.HexagonalCommerce.framework.domain.Order;
import com.br.HexagonalCommerce.framework.domain.User;
import com.br.HexagonalCommerce.framework.mapper.OrderMapper;
import com.br.HexagonalCommerce.framework.mapper.UserMapper;
import com.br.HexagonalCommerce.framework.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@DataJpaTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class OrderUseCasesImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderUseCasesImpl orderUseCasesImpl;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Criando Order!")
    void create() {
        var user = new User("admin", "admin", Roles.ADMIN);

        Order order = new Order(user);

        var savedOrder = orderRepository.save(order);

        verify(orderRepository, times(1)).save(any());
    }
}