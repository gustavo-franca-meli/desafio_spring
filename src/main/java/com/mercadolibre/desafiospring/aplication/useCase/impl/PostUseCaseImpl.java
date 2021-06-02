package com.mercadolibre.desafiospring.aplication.useCase.impl;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;
import com.mercadolibre.desafiospring.aplication.useCase.PostUseCase;
import com.mercadolibre.desafiospring.domain.Seller;
import com.mercadolibre.desafiospring.domain.factories.PostFactory;
import com.mercadolibre.desafiospring.domain.factories.SellerFactory;
import com.mercadolibre.desafiospring.infrastructure.PostRepository;
import com.mercadolibre.desafiospring.infrastructure.SellerRepository;
import org.springframework.stereotype.Service;

@Service
public class PostUseCaseImpl  implements PostUseCase {
    private PostRepository postRepository;
    private final SellerRepository sellerRepository;
    public PostUseCaseImpl(PostRepository postRepository, SellerRepository sellerRepository) {
        this.postRepository = postRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void create(CreatePostRequest postRequest) {
        var post = PostFactory.create(postRequest);
        var seller = sellerRepository.find(SellerFactory.create(post.getUserId().toString()));
        if(seller == null)throw new IllegalArgumentException("not found seller");
        if(postRepository.create(post))return;
        throw new IllegalArgumentException("post Already Exist");
    }
}
