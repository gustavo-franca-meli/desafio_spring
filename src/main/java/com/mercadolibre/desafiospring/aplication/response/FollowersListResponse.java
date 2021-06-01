package com.mercadolibre.desafiospring.aplication.response;

import java.util.List;
import java.util.UUID;

public class FollowersListResponse {
    public UUID userId;
    public String userName;
    public List<UserResponse> followers;

    public FollowersListResponse() {
    }

    public FollowersListResponse(UUID userId, String userName, List<UserResponse> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }
}
