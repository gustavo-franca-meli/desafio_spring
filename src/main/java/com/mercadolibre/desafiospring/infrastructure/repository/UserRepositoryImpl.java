package com.mercadolibre.desafiospring.infrastructure.repository;

import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.infrastructure.UserRepository;
import com.mercadolibre.desafiospring.infrastructure.database.JsonDb;
import com.mercadolibre.desafiospring.infrastructure.entity.UserData;
import com.mercadolibre.desafiospring.infrastructure.mapper.UserMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class UserRepositoryImpl extends JsonDb<UserData> implements UserRepository {
    public UserRepositoryImpl() throws Exception {
        super("user");
    }

    @Override
    public Boolean exist(User user) throws Exception {
        List<UserData> users = this.retrieve();

        if(users == null)return false;
        return users.contains(user);
    }

    @Override
    public Boolean follow(User user, User UserToFollow) {
        return null;
    }

    @Override
    public Boolean save(User user) throws Exception {
        var users = this.retrieve();
        var userData  = users.stream().filter(u -> u.getId() == user.getId()).findFirst();
        if(userData.isEmpty())users.add(UserMapper.toData(user));

        UserMapper.toData(user);


    }
}
