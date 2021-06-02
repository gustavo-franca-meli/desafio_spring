package com.mercadolibre.desafiospring.infrastructure.entity;

import com.mercadolibre.desafiospring.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserData {
    private UUID id;
    private String name;
    private List<UUID> followers = new ArrayList<>();
    private List<UUID> following = new ArrayList<>();
    private Boolean isSeller = false;

    public void setSeller(Boolean seller) {
        isSeller = seller;
    }

    public Boolean getSeller() {
        return isSeller;
    }

    public UserData() {

    }

    public UserData(UUID id, String name, List<UUID> uuidFollowers, List<UUID> uuidFollowing, Boolean isSeller) {
        this.id = id;
        this.name = name;
        this.followers = uuidFollowers;
        this.following = uuidFollowing;
        this.isSeller = isSeller;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFollowers(List<UUID> followers) {
        this.followers = followers;
    }

    public void setFollowing(List<UUID> following) {
        this.following = following;
    }

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

    public List<UUID> getFollowers() {
        return followers;
    }

    public List<UUID> getFollowing() {
        return following;
    }


}
