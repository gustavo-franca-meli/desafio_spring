package com.mercadolibre.desafiospring.aplication.useCase.impl;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;
import com.mercadolibre.desafiospring.aplication.useCase.PostUseCase;
import com.mercadolibre.desafiospring.domain.factories.PostFactory;
import com.mercadolibre.desafiospring.infrastructure.PostRepository;
import com.mercadolibre.desafiospring.infrastructure.mapper.PostMapper;
import org.springframework.stereotype.Service;

@Service
public class PostUseCaseImpl  implements PostUseCase {
    private PostRepository postRepository;

    public PostUseCaseImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void create(CreatePostRequest post) {
        postRepository.create(PostFactory.create(post));

    }
}
