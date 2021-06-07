package com.mercadolibre.desafiospring.aplication.response;

import com.mercadolibre.desafiospring.domain.PromoPost;

public class PromoPostResponseMapper {
    public static  PromoPostResponse make(PromoPost post){
        return new PromoPostResponse(post.getId(),post.getUserId(),ProductResponseMapper.make(post.getProduct()),post.getPostedAt(),post.getCategory(),post.getPrice(), post.getDiscunt());
    }
}

