package com.mercadolibre.desafiospring.domain.factories;

import com.mercadolibre.desafiospring.domain.Seller;
import com.mercadolibre.desafiospring.domain.User;

import java.util.UUID;

public class SellerFactory {

    public static Seller create(String id){
        return  new Seller(UUID.fromString(id));
    }
}
