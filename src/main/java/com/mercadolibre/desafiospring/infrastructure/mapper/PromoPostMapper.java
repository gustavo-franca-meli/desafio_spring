package com.mercadolibre.desafiospring.infrastructure.mapper;

import com.mercadolibre.desafiospring.domain.PromoPost;
import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.infrastructure.entity.PostData;

public class PromoPostMapper {
    private static Boolean hasPromo = true;
    public static PromoPost toModel(PostData postData){
        return new PromoPost(postData.getId(),new User(postData.getUserId()),postData.getPostedAt(),ProductMapper.toModel(postData.getProduct()),postData.getCategory(),postData.getPrice(),postData.getDiscount());
    }

    public static PostData toData(PromoPost post) {
        var product  = ProductMapper.toData(post.getProduct());
        return  new PostData(post.getId(),post.getUserId(),post.getPostedAt(),product,post.getCategory(),post.getPrice(), hasPromo, post.getDiscunt());
    }
}
