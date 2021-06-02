package com.mercadolibre.desafiospring.infrastructure;

import com.mercadolibre.desafiospring.domain.Seller;
import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.domain.exception.UserNotFound;

import java.util.List;


public interface UserRepository {
    Boolean exist(User user) throws Exception;
    User find(User user);
    Boolean save(User user) throws Exception;
    List<User> findAllFollowing(User user) throws Exception;
    List<User> findAllFollowers(Seller seller) throws Exception;

}
