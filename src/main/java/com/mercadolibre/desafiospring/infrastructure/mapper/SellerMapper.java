package com.mercadolibre.desafiospring.infrastructure.mapper;

import com.mercadolibre.desafiospring.domain.Seller;
import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.infrastructure.entity.UserData;

import java.util.stream.Collectors;

public class SellerMapper {


    public static UserData toData(Seller seller) {
        var uuidFollowers = seller.getFollowers().stream().map(User::getId).collect(Collectors.toList());
        var uuidFollowing =  seller.getFollowing().stream().map(User::getId).collect(Collectors.toList());
        return new UserData(seller.getId(),seller.getName(),uuidFollowers,uuidFollowing,true);
    }

    public static Seller toModel(UserData userData) {
        var userFollowing = userData.getFollowing().stream().map(Seller::new).collect(Collectors.toList());
        var userFollowers = userData.getFollowers().stream().map(User::new).collect(Collectors.toList());
        return new Seller(userData.getId(),userData.getName(),userFollowers,userFollowing);
    }
}
