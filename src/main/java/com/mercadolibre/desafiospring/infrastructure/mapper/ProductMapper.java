package com.mercadolibre.desafiospring.infrastructure.mapper;

import com.mercadolibre.desafiospring.domain.Product;
import com.mercadolibre.desafiospring.infrastructure.entity.ProductData;

public class ProductMapper {

    public static ProductData toData(Product product){
        return new ProductData(product.getId(),product.getName(),product.getType(),product.getBrand(),product.getColor(),product.getNotes());
    }

    public static Product toModel(ProductData product) {
        return new Product(product.getId(),product.getName(),product.getType(),product.getBrand(),product.getColor(),product.getNotes());
    }
}
