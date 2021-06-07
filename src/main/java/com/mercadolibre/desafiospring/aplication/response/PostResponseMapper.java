package com.mercadolibre.desafiospring.aplication.response;

import com.mercadolibre.desafiospring.domain.Post;

public class PostResponseMapper {

    public static  PostResponse make(Post post){
        return new PostResponse(post.getId(),post.getUserId(),ProductResponseMapper.make(post.getProduct()),post.getPostedAt(),post.getCategory(),post.getPrice());
    }
}
