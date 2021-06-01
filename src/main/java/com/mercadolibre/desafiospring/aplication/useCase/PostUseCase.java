package com.mercadolibre.desafiospring.aplication.useCase;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;

public interface PostUseCase {

    void create(CreatePostRequest post);
}
