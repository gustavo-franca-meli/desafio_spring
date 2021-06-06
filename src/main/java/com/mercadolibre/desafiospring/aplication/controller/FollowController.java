package com.mercadolibre.desafiospring.aplication.controller;

import com.mercadolibre.desafiospring.aplication.response.FollowersCountResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowersListResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowingListResponse;
import com.mercadolibre.desafiospring.aplication.useCase.UserUseCase;
import com.mercadolibre.desafiospring.domain.exception.RepositoryNotAvailable;
import com.mercadolibre.desafiospring.domain.exception.UserIsAlreadyFollowingException;
import com.mercadolibre.desafiospring.domain.exception.UserIsAlreadyUnfollowingException;
import com.mercadolibre.desafiospring.domain.exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}/")
public class FollowController {
    private UserUseCase userUseCase;

    public FollowController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }


    @PostMapping("/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable String userId, @PathVariable String userIdToFollow) throws Exception, UserIsAlreadyFollowingException {
        userUseCase.follow(userId,userIdToFollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/followers/count")
    public ResponseEntity<FollowersCountResponse> followersCount(@PathVariable String userId) throws Exception, UserIsAlreadyFollowingException {
         var response = userUseCase.followersCount(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/followed/list")
    public ResponseEntity<FollowingListResponse> followedList(@PathVariable String userId) throws Exception, UserIsAlreadyFollowingException {
        var response = userUseCase.followingList(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/followers/list")
    public ResponseEntity<FollowersListResponse> followersList(@PathVariable String userId) throws Exception, UserIsAlreadyFollowingException {
        var response = userUseCase.followersList(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/unfollow/{userIdToUnfollow}")
    public ResponseEntity<Void> unfollow(@PathVariable String userId, @PathVariable String userIdToUnfollow) throws UserNotFound, UserIsAlreadyUnfollowingException, RepositoryNotAvailable {
        userUseCase.unfollow(userId,userIdToUnfollow);
        return ResponseEntity.ok().build();
    }
}
