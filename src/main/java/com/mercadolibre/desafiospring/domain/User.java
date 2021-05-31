package com.mercadolibre.desafiospring.domain;

import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private List<User> followers;
    private List<User> following;

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

    public User(UUID id) {
        this.id = id;
    }

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public void follow(User userToFollow) {
         userToFollow.followers.add(this);
         followers.add(userToFollow);
         return;
    }
}
