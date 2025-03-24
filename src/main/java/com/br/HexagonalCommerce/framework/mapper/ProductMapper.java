package com.br.HexagonalCommerce.framework.mapper;

import com.br.HexagonalCommerce.core.entities.ProductEntity;
import com.br.HexagonalCommerce.framework.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    @Lazy
    @Autowired
    private OrderMapper orderMapper;

    public ProductEntity toProductEntityAll(Product product){
        return new ProductEntity(
                product.getId()
                , product.getName()
                , product.getQuantity()
                , product.getPrice()
                , orderMapper.toOrderEntityAll(product.getOrder())
        );
    }

    public Product toProductAll(ProductEntity productEntity){
        return new Product(
                productEntity.getId()
                , productEntity.getName()
                , productEntity.getQuantity()
                , productEntity.getPrice()
                , orderMapper.toOrderAll(productEntity.getOrder())
        );
    }

    public ProductEntity toProductEntity(Product product){
        return new ProductEntity(product.getName()
                , product.getQuantity()
                , product.getPrice()
                , orderMapper.toOrderEntityAll(product.getOrder()));
    }

    public Product toProduct(ProductEntity product){
        return new Product(product.getName()
                , product.getQuantity()
                , product.getPrice()
                , orderMapper.toOrderAll(product.getOrder()));
    }

    public List<ProductEntity> toListProductEntity(List<Product> productList){
        List<ProductEntity> productEntity = new ArrayList<>();
        for(Product product : productList){
            productEntity.add(new ProductEntity(
                    product.getName()
                    , product.getQuantity()
                    , product.getPrice()
                    , orderMapper.toOrderEntityAll(product.getOrder())
            ));
        }
        return productEntity;
    }

    public List<Product> toListProduct(List<ProductEntity> productEntityList){
        List<Product> productList = new ArrayList<>();
        for(ProductEntity productEntity : productEntityList){
            productList.add(
                    new Product(productEntity.getName()
                            , productEntity.getQuantity()
                            , productEntity.getPrice()
                            , orderMapper.toOrderAll(productEntity.getOrder())));
        }
        return productList;
    }

}
