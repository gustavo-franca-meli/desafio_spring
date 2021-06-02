package com.mercadolibre.desafiospring.aplication.response;

import java.util.List;
import java.util.UUID;

public class PostsResponse {
    UUID userId;
    List<PostResponse> posts;

    public PostsResponse() {
    }

    public PostsResponse(UUID userId, List<PostResponse> posts) {
        this.userId = userId;
        this.posts = posts;
    }
}
