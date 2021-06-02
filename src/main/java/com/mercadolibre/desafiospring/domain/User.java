package com.mercadolibre.desafiospring.domain;

import com.mercadolibre.desafiospring.domain.exception.UserIsAlreadyFollowingException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private List<Seller> following = new ArrayList<>();


    public User(UUID id, String name, List<Seller> following) {
        this.id = id;
        this.name = name;
        this.following = following;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Seller> getFollowing() {
        return following;
    }

    public User(UUID id) {
        this.id = id;
    }

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Boolean follow(Seller sellerToFollow) {
        try {
            if(sellerToFollow.getId().equals(this.getId()))return false;
            var isFollowing = this.following.stream().anyMatch(u -> u.getId().equals(sellerToFollow.getId()));
            if (isFollowing) return false;
            if (!sellerToFollow.addFollower(this)) return false;
            following.add(sellerToFollow);
            return true;
        } catch (Exception e) {
            sellerToFollow.removeFollower(this);
            unFollow(sellerToFollow);
            return false;
        }
    }

    public void unFollow(Seller userToUnFollow) {
        this.following.remove(userToUnFollow);
    }

}


