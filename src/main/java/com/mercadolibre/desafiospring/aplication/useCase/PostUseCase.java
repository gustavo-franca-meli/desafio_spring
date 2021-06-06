package com.mercadolibre.desafiospring.aplication.useCase;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;
import com.mercadolibre.desafiospring.aplication.requests.OrderPost;
import com.mercadolibre.desafiospring.aplication.response.PostsResponse;
import com.mercadolibre.desafiospring.domain.exception.UserNotFound;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface PostUseCase {

    void create(CreatePostRequest post);


    PostsResponse listFollowedBy(String userId, Optional<OrderPost> order) throws UserNotFound;
}
