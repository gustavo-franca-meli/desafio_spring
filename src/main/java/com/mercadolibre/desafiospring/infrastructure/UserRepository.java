package com.mercadolibre.desafiospring.infrastructure;

import com.mercadolibre.desafiospring.aplication.requests.OrderQuery;
import com.mercadolibre.desafiospring.domain.Seller;
import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.domain.exception.RepositoryNotAvailable;

import java.util.List;


public interface UserRepository {
    Boolean exist(User user) throws RepositoryNotAvailable;
    User find(User user);
    Boolean save(User user) throws RepositoryNotAvailable;
    List<User> findAllFollowing(User user) throws RepositoryNotAvailable;
    List<User> findAllFollowers(Seller seller) throws RepositoryNotAvailable;

    List<User> findAllFollowers(Seller seller, OrderQuery orderQuery) throws RepositoryNotAvailable;

    List<User> findAllFollowing(User user, OrderQuery orderQuery) throws RepositoryNotAvailable;
}
