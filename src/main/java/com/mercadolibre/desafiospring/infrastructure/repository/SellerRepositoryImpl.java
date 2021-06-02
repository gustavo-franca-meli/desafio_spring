package com.mercadolibre.desafiospring.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mercadolibre.desafiospring.domain.Seller;
import com.mercadolibre.desafiospring.infrastructure.SellerRepository;
import com.mercadolibre.desafiospring.infrastructure.database.JsonDb;
import com.mercadolibre.desafiospring.infrastructure.entity.UserData;
import com.mercadolibre.desafiospring.infrastructure.mapper.SellerMapper;
import com.mercadolibre.desafiospring.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class SellerRepositoryImpl extends JsonDb<UserData> implements SellerRepository {
    private static  TypeReference<List<UserData>> typeRef = new TypeReference<>(){};
    public SellerRepositoryImpl() throws IOException {
        super("user", typeRef);
    }


    @Override
    public Seller find(Seller seller) {
        try {
            var users = this.retrieve();
            return SellerMapper.toModel(users.stream().filter(u -> u.getSeller() && u.getId().equals(seller.getId())  ).findFirst().get());

        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public Boolean save(Seller user) throws Exception {
        var users = this.retrieve();
        var data = SellerMapper.toData(user);
        users.removeIf(userData -> userData.getId().equals(data.getId()));
        users.add(data);
        this.update(users);
        return true;
    }

}

