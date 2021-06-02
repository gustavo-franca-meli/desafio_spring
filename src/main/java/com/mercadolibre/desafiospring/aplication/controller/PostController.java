package com.mercadolibre.desafiospring.aplication.controller;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;
import com.mercadolibre.desafiospring.aplication.response.PostsResponse;
import com.mercadolibre.desafiospring.aplication.useCase.PostUseCase;
import com.mercadolibre.desafiospring.domain.exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/products/")
public class PostController {
    private final PostUseCase postUseCase;

    public PostController(PostUseCase postUseCase) {
        this.postUseCase = postUseCase;
    }

    @PostMapping("/newpost/")
    public ResponseEntity<Void> createPost(@RequestBody CreatePostRequest post){

        postUseCase.create(post);
        return status(HttpStatus.CREATED).build();
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsResponse> listFollowedPost(@PathVariable String userId) throws UserNotFound {
        var response = postUseCase.listFollowedBy(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
