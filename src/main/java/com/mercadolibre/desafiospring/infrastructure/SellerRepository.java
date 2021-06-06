package com.mercadolibre.desafiospring.infrastructure;

import com.mercadolibre.desafiospring.domain.Seller;
import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.domain.exception.RepositoryNotAvailable;

import java.util.List;

public interface SellerRepository {
    Seller find(Seller user);
    Boolean save(Seller user) throws RepositoryNotAvailable;
}
