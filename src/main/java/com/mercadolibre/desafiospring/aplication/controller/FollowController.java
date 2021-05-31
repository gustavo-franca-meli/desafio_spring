package com.mercadolibre.desafiospring.aplication.controller;

import com.mercadolibre.desafiospring.aplication.useCase.UserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{userId}/")
public class FollowController {
    private UserUseCase userUseCase;

    public FollowController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }


    @PostMapping("/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable String userId, @PathVariable String userIdToFollow){
        userUseCase.follow(userId,userIdToFollow);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
