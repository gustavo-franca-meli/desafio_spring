package com.mercadolibre.desafiospring.domain.factories;

import com.mercadolibre.desafiospring.aplication.requests.CreatePromoPostRequest;
import com.mercadolibre.desafiospring.domain.Product;
import com.mercadolibre.desafiospring.domain.PromoPost;
import com.mercadolibre.desafiospring.domain.User;

import java.util.UUID;

public class PromoPostFactory {

    public  static PromoPost create(CreatePromoPostRequest post){
        var product = new Product(UUID.fromString(post.detail.productId),post.detail.productName,post.detail.type,post.detail.brand,post.detail.color,post.detail.notes);
        return new PromoPost(UUID.fromString(post.idPost),new User(UUID.fromString(post.userId)),product,post.category, post.price,post.discount);
    }
}
