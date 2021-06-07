package com.mercadolibre.desafiospring.aplication.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class PromoPostResponse extends  PostResponse{
    public Double discount;

    public PromoPostResponse() {
    }

    public PromoPostResponse(UUID userId, UUID idPost, ProductResponse detail, LocalDateTime postedAt, Integer category, Double price, Double discount) {
        super(userId, idPost, detail, postedAt, category, price);
        this.discount = discount;
    }
}
