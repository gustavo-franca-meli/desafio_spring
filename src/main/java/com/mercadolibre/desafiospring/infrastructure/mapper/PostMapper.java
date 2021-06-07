package com.mercadolibre.desafiospring.infrastructure.mapper;

import com.mercadolibre.desafiospring.domain.Post;
import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.infrastructure.entity.PostData;

public class PostMapper {
    private static Boolean hasPromo = false;
    public static Post toModel(PostData postData){
        return new Post(postData.getId(),new User(postData.getUserId()),postData.getPostedAt(),ProductMapper.toModel(postData.getProduct()),postData.getCategory(),postData.getPrice());
    }

    public static PostData toData(Post post) {
        var product  = ProductMapper.toData(post.getProduct());
        return  new PostData(post.getId(),post.getUserId(),post.getPostedAt(),product,post.getCategory(),post.getPrice(), hasPromo, 0.);
    }
}
