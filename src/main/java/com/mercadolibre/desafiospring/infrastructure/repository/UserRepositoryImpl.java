package com.mercadolibre.desafiospring.infrastructure.repository;

import com.mercadolibre.desafiospring.aplication.requests.OrderQuery;
import com.mercadolibre.desafiospring.domain.Seller;
import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.domain.exception.RepositoryNotAvailable;
import com.mercadolibre.desafiospring.infrastructure.UserRepository;
import com.mercadolibre.desafiospring.infrastructure.database.JsonDb;
import com.mercadolibre.desafiospring.infrastructure.entity.PostData;
import com.mercadolibre.desafiospring.infrastructure.entity.UserData;
import com.mercadolibre.desafiospring.infrastructure.mapper.PostMapper;
import com.mercadolibre.desafiospring.infrastructure.mapper.UserMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl extends JsonDb<UserData> implements UserRepository {
    private static  TypeReference<List<UserData>> typeRef = new TypeReference<>(){};
    public UserRepositoryImpl() throws RepositoryNotAvailable {
        super("user",typeRef);


    }

    @Override
    public Boolean exist(User user) throws RepositoryNotAvailable {
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
    public Boolean save(User user) throws RepositoryNotAvailable {
        var users = this.retrieve();
        var data = UserMapper.toData(user);
        var userDataDBOp = users.stream().filter(userData -> userData.getId().equals(data.getId())).findFirst();
        if(userDataDBOp.isPresent()){
            var userData = userDataDBOp.get();
            data.setFollowers(userData.getFollowers());
            data.setSeller(userData.getSeller());
            users.remove(userData);
        }
        users.add(data);
        this.update(users);
        return true;
    }

    @Override
    public List<User> findAllFollowers(Seller seller) throws RepositoryNotAvailable {
        var users = this.retrieve();

        return users.stream()
                .filter(
                        u ->  seller.getFollowers()
                                .stream().anyMatch(
                                        follower ->   follower.getId().equals(u.getId()
                                        )
                                )
                )
                .map(UserMapper::toModel)
                .collect(Collectors.toList());


    }

    @Override
    public List<User> findAllFollowers(Seller seller, OrderQuery orderQuery) throws RepositoryNotAvailable {
       var followers =  this.findAllFollowers(seller);
        return followers.stream().sorted(Comparator.comparing(User::getName,orderQuery.equals(OrderQuery.name_desc)? Comparator.reverseOrder():Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findAllFollowing(User user) throws RepositoryNotAvailable {
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
    @Override
    public List<User> findAllFollowing(User user, OrderQuery orderQuery) throws RepositoryNotAvailable {
        var followers =  this.findAllFollowing(user);
        return followers.stream().sorted(Comparator.comparing(User::getName,orderQuery.equals(OrderQuery.name_desc)? Comparator.reverseOrder():Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
}
