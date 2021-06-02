package com.mercadolibre.desafiospring.aplication.useCase;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;
import com.mercadolibre.desafiospring.aplication.response.PostsResponse;
import com.mercadolibre.desafiospring.domain.exception.UserNotFound;
import org.springframework.http.ResponseEntity;

public interface PostUseCase {

    void create(CreatePostRequest post);

    PostsResponse listFollowedBy(String userId) throws UserNotFound;
}
