package com.mercadolibre.desafiospring.infrastructure.mapper;

import com.mercadolibre.desafiospring.domain.Post;
import com.mercadolibre.desafiospring.infrastructure.entity.PostData;

public class PostMapper {
    public static PostData toData(Post post) {
        var product  = ProductMapper.toData(post.getProduct());
        return  new PostData(post.getId(),post.getUserId(),post.getDate(),product,post.getCategory(),post.getPrice());
    }
}
