package com.mercadolibre.desafiospring.infrastructure.mapper;

import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.infrastructure.entity.UserData;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserMapper {


    public static UserData toData(User user) {
        var uuidFollowers = user.getFollowers().stream().map(User::getId).collect(Collectors.toList());
        var uuidFollowing =  user.getFollowing().stream().map(User::getId).collect(Collectors.toList());
        return new UserData(user.getId(),user.getName(),uuidFollowers,uuidFollowing);
    }

    public static User toModel(UserData userData) {
        var userFollowing = userData.getFollowing().stream().map(User::new).collect(Collectors.toList());
        var userFollowers = userData.getFollowers().stream().map(User::new).collect(Collectors.toList());
        return new User(userData.getId(),userData.getName(),userFollowers,userFollowing);
    }
}
