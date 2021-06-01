package com.mercadolibre.desafiospring.domain;

import com.mercadolibre.desafiospring.domain.exception.UserIsAlreadyFollowingException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private List<User> followers = new ArrayList<>();
    private List<User> following = new ArrayList<>();


    public User(UUID id, String name, List<User> followers, List<User> following) {
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

    public User(UUID id) {
        this.id = id;
    }

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Boolean follow(User userToFollow) {
        try{
            var isFollowing = this.following.stream().anyMatch(u ->u.getId().equals(userToFollow.getId()));
            if(isFollowing)return false;
            if(!userToFollow.addFollower(this))return false;
            following.add(userToFollow);
            return true;
        }catch (Exception  e){
            userToFollow.removeFollower(this);
            unFollow(userToFollow);
            return  false;
        }
    }

    private void unFollow(User userToUnFollow) {
        this.following.remove(userToUnFollow);
    }

    private void removeFollower(User user) {
        this.followers.remove(user);
    }

    public Boolean addFollower(User user) {
        var isAFollower = this.followers.stream().anyMatch(u ->u.getId().equals(user.getId()));
        if(isAFollower)return false;
        this.followers.add(user);
        return true;
    }

    public Integer followersCount() {
        return this.followers.size();
    }
}
