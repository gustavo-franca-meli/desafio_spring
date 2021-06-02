package com.mercadolibre.desafiospring.infrastructure.mapper;

import com.mercadolibre.desafiospring.domain.Seller;
import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.infrastructure.entity.UserData;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserMapper {


    public static UserData toData(User user) {
        var uuidFollowing =  user.getFollowing().stream().map(User::getId).collect(Collectors.toList());
        return new UserData(user.getId(),user.getName(),null,uuidFollowing);
    }

    public static User toModel(UserData userData) {
        var userFollowing = userData.getFollowing().stream().map(Seller::new).collect(Collectors.toList());
        return new User(userData.getId(),userData.getName(),userFollowing);
    }
}
