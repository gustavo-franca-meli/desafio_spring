package com.mercadolibre.desafiospring.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Seller extends User{
    private List<User> followers = new ArrayList<>();
    public Seller(UUID id, String name, List<User> followers, List<Seller> following) {
        super(id, name, following);
        this.followers = followers;
    }

    public Seller(UUID id) {
        super(id);
    }

    public Seller(UUID id, String name) {
        super(id, name);
    }

    public List<User> getFollowers() {
        return followers;
    }

    public boolean removeFollower(User user) {
        return this.followers.removeIf(f -> f.getId().equals(user.getId()));
    }

    public Boolean addFollower(User user) throws IllegalArgumentException {
        if(user.getId().equals(this.getId()))throw new IllegalArgumentException("User " + this.getId()+ " not able to follow yourself");
        var isAFollower = this.followers.stream().anyMatch(u ->u.getId().equals(user.getId()));
        if(isAFollower)return false;
        this.followers.add(user);
        return true;
    }

    public Integer followersCount() {
        return this.followers.size();
    }
}

