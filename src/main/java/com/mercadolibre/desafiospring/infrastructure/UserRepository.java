package com.mercadolibre.desafiospring.infrastructure;

import com.mercadolibre.desafiospring.domain.User;


public interface UserRepository {
    Boolean exist(User user) throws Exception;
    Boolean follow(User user, User UserToFollow);
    Boolean save(User user) throws Exception;
}
