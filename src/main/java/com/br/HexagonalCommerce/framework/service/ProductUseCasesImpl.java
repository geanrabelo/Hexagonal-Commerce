package com.br.HexagonalCommerce.framework.service;

import com.br.HexagonalCommerce.core.entities.ProductEntity;
import com.br.HexagonalCommerce.core.exceptions.ProductNotFound;
import com.br.HexagonalCommerce.core.usecases.ProductUseCases;
import com.br.HexagonalCommerce.framework.mapper.ProductMapper;
import com.br.HexagonalCommerce.framework.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductUseCasesImpl implements ProductUseCases {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    public ProductUseCasesImpl(ProductMapper productMapper, ProductRepository productRepository){
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public void create(ProductEntity productEntity) {
        var product = productMapper.toProductAll(productEntity);
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) throws ProductNotFound {
        if(existsById(id)){
            productRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(Long id) throws ProductNotFound {
        if(!productRepository.existsById(id)){
            throw new ProductNotFound("Product searched by id not found");
        }else{
            return true;
        }
    }

    @Override
    public ProductEntity findById(Long id) throws ProductNotFound {
        if(existsById(id)){
            var product = productRepository.getReferenceById(id);
            return productMapper.toProductEntityAll(product);
        }else{
            return null;
        }
    }
}