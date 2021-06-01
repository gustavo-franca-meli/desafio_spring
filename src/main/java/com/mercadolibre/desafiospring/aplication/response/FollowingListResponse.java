package com.mercadolibre.desafiospring.aplication.response;

import java.util.List;
import java.util.UUID;

public class FollowingListResponse {
    public UUID userId;
    public String userName;
    public List<UserResponse> followed;

    public FollowingListResponse() {
    }

    public FollowingListResponse(UUID userId, String userName, List<UserResponse> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
    }
}
