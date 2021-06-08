package com.mercadolibre.desafiospring.aplication.controller;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;
import com.mercadolibre.desafiospring.aplication.requests.CreatePromoPostRequest;
import com.mercadolibre.desafiospring.aplication.requests.OrderPost;
import com.mercadolibre.desafiospring.aplication.response.CountPromoPostsResponse;
import com.mercadolibre.desafiospring.aplication.response.PostsResponse;
import com.mercadolibre.desafiospring.aplication.response.PromoPostsResponse;
import com.mercadolibre.desafiospring.aplication.useCase.PostUseCase;
import com.mercadolibre.desafiospring.domain.exception.PostAlreadyExistException;
import com.mercadolibre.desafiospring.domain.exception.SellerNotFoundException;
import com.mercadolibre.desafiospring.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/products/")
public class PostController {
    private final PostUseCase postUseCase;

    public PostController(PostUseCase postUseCase) {
        this.postUseCase = postUseCase;
    }

    @PostMapping("/newpost/")
    public ResponseEntity<Void> createPost(@RequestBody CreatePostRequest post) throws SellerNotFoundException, PostAlreadyExistException {

        postUseCase.create(post);
        return status(HttpStatus.CREATED).build();
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsResponse> listFollowedPost(@PathVariable String userId, @RequestParam("order") Optional<OrderPost> order) throws UserNotFoundException {
        var response = postUseCase.listFollowedBy(userId,order);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/newpromopost/")
    public ResponseEntity<Void> createPost(@Valid @RequestBody CreatePromoPostRequest post) throws SellerNotFoundException, PostAlreadyExistException {
        postUseCase.create(post);
        return status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<CountPromoPostsResponse> countPromoPosts(@PathVariable String userId) throws UserNotFoundException, SellerNotFoundException {
        var response = postUseCase.countPromoPosts(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<PromoPostsResponse> listPromoPostOfUser(@PathVariable String userId, @RequestParam("order") Optional<OrderPost> order) throws UserNotFoundException, SellerNotFoundException {
        var response = postUseCase.listPromoPost(userId,order);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
