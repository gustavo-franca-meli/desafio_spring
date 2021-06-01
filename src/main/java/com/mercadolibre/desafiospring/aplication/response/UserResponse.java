package com.mercadolibre.desafiospring.aplication.response;

import com.mercadolibre.desafiospring.domain.User;

import java.util.UUID;

public class UserResponse {
    public UUID userId;
    public String userName;
    public UserResponse() {

    }

    public UserResponse(UUID userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserResponse(User user) {
        this(user.getId(),user.getName());
    }
}
