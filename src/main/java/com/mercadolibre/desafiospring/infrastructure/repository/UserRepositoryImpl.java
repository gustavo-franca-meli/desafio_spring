package com.mercadolibre.desafiospring.infrastructure.repository;

import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.infrastructure.UserRepository;
import com.mercadolibre.desafiospring.infrastructure.database.JsonDb;
import com.mercadolibre.desafiospring.infrastructure.entity.UserData;
import com.mercadolibre.desafiospring.infrastructure.mapper.UserMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl extends JsonDb<UserData> implements UserRepository {
    private static  TypeReference<List<UserData>> typeRef = new TypeReference<>(){};
    public UserRepositoryImpl() throws Exception {
        super("user",typeRef);


    }

    @Override
    public Boolean exist(User user) throws Exception {
        List<UserData> users = this.retrieve();

        if(users == null)return false;
        return users.contains(user);
    }

    @Override
    public User find(User user) {
        try {
            var users = this.retrieve();
            return UserMapper.toModel(users.stream().filter(u -> u.getId().equals(user.getId())).findFirst().get());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Boolean follow(User user, User UserToFollow) {
        return null;
    }

    @Override
    public Boolean save(User user) throws Exception {
        var users = this.retrieve();
        var data = UserMapper.toData(user);
        users.removeIf(userData -> userData.getId().equals(data.getId()));
        users.add(data);
        this.update(users);
        return true;
    }

    @Override
    public List<User> findAllFollowers(User user) throws Exception {
        var users = this.retrieve();

         return users.stream()
                .filter(
                        u -> user.getFollowers()
                                        .stream().anyMatch(
                                                follower ->   follower.getId().equals(u.getId()
                                                        )
                                )
                )
                .map(UserMapper::toModel)
                 .collect(Collectors.toList());


    }

    @Override
    public List<User> findAllFollowing(User user) throws Exception {
        var users = this.retrieve();

        return users.stream()
                .filter(
                        u -> user.getFollowing()
                                .stream().anyMatch(
                                        followed ->   followed.getId().equals(u.getId()
                                        )
                                )
                )
                .map(UserMapper::toModel)
                .collect(Collectors.toList());

    }
}
