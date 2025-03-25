package com.br.HexagonalCommerce.framework.service;

import com.br.HexagonalCommerce.core.entities.OrderEntity;
import com.br.HexagonalCommerce.core.entities.ProductEntity;
import com.br.HexagonalCommerce.core.entities.UserEntity;
import com.br.HexagonalCommerce.core.enums.Roles;
import com.br.HexagonalCommerce.framework.domain.Product;
import com.br.HexagonalCommerce.framework.mapper.ProductMapper;
import com.br.HexagonalCommerce.framework.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class ProductUseCasesImplTest {

    @Mock
    private ProductMapper productMapper;

    @Mock
    private ProductRepository productRepository;


    @InjectMocks
    private ProductUseCasesImpl productUseCasesImpl;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create() {
        UserEntity userEntity = new UserEntity("admin", "admin", Roles.ADMIN);
        OrderEntity orderEntity = new OrderEntity(userEntity);
        ProductEntity productEntity = new ProductEntity("toy", 5, 75, orderEntity);
        Product product = productMapper.toProduct(productEntity);
        productRepository.save(product);

        verify(productRepository.save(any()), times(1));
    }
}