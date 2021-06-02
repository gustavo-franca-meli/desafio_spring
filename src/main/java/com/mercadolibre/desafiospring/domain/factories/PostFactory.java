package com.mercadolibre.desafiospring.domain.factories;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;
import com.mercadolibre.desafiospring.domain.Post;
import com.mercadolibre.desafiospring.domain.Product;
import com.mercadolibre.desafiospring.domain.User;

import java.util.UUID;

public class PostFactory {

    public  static Post create(CreatePostRequest post){
        var product = new Product(UUID.fromString(post.detail.productId),post.detail.productName,post.detail.type,post.detail.brand,post.detail.color,post.detail.notes);
        return new Post(UUID.fromString(post.idPost),new User(UUID.fromString(post.userId)),post.date,product,post.category, post.price);
    }
}
