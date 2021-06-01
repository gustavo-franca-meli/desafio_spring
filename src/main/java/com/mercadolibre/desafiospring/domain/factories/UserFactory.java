package com.mercadolibre.desafiospring.domain.factories;

import com.mercadolibre.desafiospring.domain.User;

import java.util.UUID;

public class UserFactory {

    public static User create(String id){
        return  new User(UUID.fromString(id));
    }
}
