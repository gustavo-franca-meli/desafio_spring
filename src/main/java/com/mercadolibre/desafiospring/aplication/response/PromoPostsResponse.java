package com.mercadolibre.desafiospring.aplication.response;



import java.util.List;
import java.util.UUID;

public class PromoPostsResponse {
    public UUID userId;
    public String userName;
    public List<PromoPostResponse> posts;

    public PromoPostsResponse() {
    }

    public PromoPostsResponse(UUID userId, String userName,List<PromoPostResponse> posts) {
        this.userName = userName;
        this.userId = userId;
        this.posts = posts;
    }
}
