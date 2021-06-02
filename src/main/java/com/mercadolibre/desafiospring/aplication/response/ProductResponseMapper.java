package com.mercadolibre.desafiospring.aplication.response;

import com.mercadolibre.desafiospring.domain.Product;

public class ProductResponseMapper {

    public static ProductResponse make(Product product){
        return new ProductResponse(product.getId(),product.getName(),product.getType(),product.getBrand(),product.getColor(),product.getNotes());
    }
}
