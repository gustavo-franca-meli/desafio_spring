package com.mercadolibre.desafiospring.infrastructure.entity;

import com.mercadolibre.desafiospring.domain.User;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserData {
    private UUID id;
    private String name;
    private List<UUID> followers;
    private List<UUID> following;

    public UserData(UUID id, String name, List<UUID> followers, List<UUID> following) {
        this.id = id;
        this.name = name;
        this.followers = followers;
        this.following = following;
    }



    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<User> getFollowing() {
        return following;
    }


}
