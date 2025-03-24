package com.br.HexagonalCommerce.framework.controller;

import com.br.HexagonalCommerce.core.entities.UserEntity;
import com.br.HexagonalCommerce.core.exceptions.OrderNotFound;
import com.br.HexagonalCommerce.core.exceptions.UserNotFound;
import com.br.HexagonalCommerce.core.usecases.OrderUseCases;
import com.br.HexagonalCommerce.core.usecases.UserUseCases;
import com.br.HexagonalCommerce.framework.dto.order.OrderCreatedDTO;
import com.br.HexagonalCommerce.framework.dto.order.OrderResponseDTO;
import com.br.HexagonalCommerce.framework.mapper.UserMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/commerce/order")
public class OrderController {

    @Autowired
    private OrderUseCases orderUseCases;

    @Autowired
    private UserUseCases userUseCases;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid OrderResponseDTO orderResponseDTO, UriComponentsBuilder uriComponentsBuilder) throws UserNotFound {
        var userEntity = userUseCases.findById(orderResponseDTO.id_user());
        var uuid = orderUseCases.create(userEntity);
        var uri = uriComponentsBuilder.path("/commerce/order").buildAndExpand(uuid).toUri();
        var user = userMapper.toUserWithId(userEntity);
        return ResponseEntity.created(uri).body(new OrderCreatedDTO(uuid, user));
    }

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam(value = "uuid") String uuid) throws OrderNotFound {
        return ResponseEntity.ok(orderUseCases.findById(UUID.fromString(uuid)));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> deleteById(@RequestParam(value = "uuid") String uuid) throws OrderNotFound {
        orderUseCases.deleteById(UUID.fromString(uuid));
        return ResponseEntity.noContent().build();
    }

}
