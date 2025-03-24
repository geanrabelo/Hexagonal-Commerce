package com.br.HexagonalCommerce.framework.controller;

import com.br.HexagonalCommerce.core.entities.ProductEntity;
import com.br.HexagonalCommerce.core.exceptions.OrderNotFound;
import com.br.HexagonalCommerce.core.exceptions.ProductNotFound;
import com.br.HexagonalCommerce.core.usecases.OrderUseCases;
import com.br.HexagonalCommerce.core.usecases.ProductUseCases;
import com.br.HexagonalCommerce.framework.dto.product.ProductResponseDTO;
import com.br.HexagonalCommerce.framework.dto.user.ResponseDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/commerce/product")
public class ProductController {

    @Autowired
    private ProductUseCases productUseCases;

    @Autowired
    private OrderUseCases orderUseCases;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid ProductResponseDTO productResponseDTO, UriComponentsBuilder uriComponentsBuilder) throws OrderNotFound {
        var orderEntity = orderUseCases.findById(UUID.fromString(productResponseDTO.order_uuid()));
        var productEntity = new ProductEntity(productResponseDTO.name(), productResponseDTO.quantity(), productResponseDTO.price(), orderEntity);
        productUseCases.create(productEntity);
        var uri = uriComponentsBuilder.path("/commerce/product").buildAndExpand(productEntity).toUri();
        return ResponseEntity.created(uri).body(new ResponseDTO("Product created sucessfull!"));
    }

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam(value = "id") Long id) throws ProductNotFound {
        return ResponseEntity.ok(productUseCases.findById(id));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> delete(@RequestParam(value = "id") Long id) throws ProductNotFound {
        productUseCases.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
