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

    public void removeFollower(User user) {
        this.followers.remove(user);
    }

    public Boolean addFollower(User user) {
        if(user.getId().equals(this.getId()))return false;
        var isAFollower = this.followers.stream().anyMatch(u ->u.getId().equals(user.getId()));
        if(isAFollower)return false;
        this.followers.add(user);
        return true;
    }

    public Integer followersCount() {
        return this.followers.size();
    }
}

