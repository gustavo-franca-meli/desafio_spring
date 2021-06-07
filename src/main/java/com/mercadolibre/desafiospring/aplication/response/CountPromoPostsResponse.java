package com.mercadolibre.desafiospring.aplication.response;

import java.util.UUID;

public class CountPromoPostsResponse {
    public UUID userId;
    public String userName;
    public Integer promoProductsCount;

    public CountPromoPostsResponse(UUID userId, String userName, Integer promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }

    public CountPromoPostsResponse() {
    }
}
