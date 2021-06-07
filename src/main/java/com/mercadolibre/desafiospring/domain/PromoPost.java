package com.mercadolibre.desafiospring.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class PromoPost  extends Post{
    private Double discount;
    public PromoPost(UUID id, User user, LocalDateTime postedAt, Product product, Integer category, Double price, Double discount) {
        super(id, user, postedAt, product, category, price);
        this.discount = discount;
    }

    public PromoPost(UUID idPost, User user, Product product, Integer category, Double price, Double discount) {
        super(idPost, user, product, category, price);
        this.discount = discount;
    }

    public Double getDiscunt() {
        return this.discount;
    }
}
