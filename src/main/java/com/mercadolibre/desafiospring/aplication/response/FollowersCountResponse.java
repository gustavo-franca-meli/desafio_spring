package com.mercadolibre.desafiospring.aplication.response;

import java.util.UUID;

public class FollowersCountResponse {
    public UUID userId;
    public String userName;
    public Integer followersCount;

    public FollowersCountResponse() {
    }

    public FollowersCountResponse(UUID userId, String userName, Integer followersCount) {
        this.userId = userId;
        this.userName = userName;
        this.followersCount = followersCount;
    }
}
