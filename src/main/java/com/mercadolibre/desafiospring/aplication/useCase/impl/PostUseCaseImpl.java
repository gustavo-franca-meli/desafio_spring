package com.mercadolibre.desafiospring.aplication.useCase.impl;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;
import com.mercadolibre.desafiospring.aplication.response.PostsResponse;
import com.mercadolibre.desafiospring.aplication.response.PostResponseMapper;
import com.mercadolibre.desafiospring.aplication.useCase.PostUseCase;
import com.mercadolibre.desafiospring.domain.exception.UserNotFound;
import com.mercadolibre.desafiospring.domain.factories.PostFactory;
import com.mercadolibre.desafiospring.domain.factories.SellerFactory;
import com.mercadolibre.desafiospring.domain.factories.UserFactory;
import com.mercadolibre.desafiospring.infrastructure.PostRepository;
import com.mercadolibre.desafiospring.infrastructure.SellerRepository;
import com.mercadolibre.desafiospring.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class PostUseCaseImpl  implements PostUseCase {
    private PostRepository postRepository;
    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;
    public PostUseCaseImpl(PostRepository postRepository, SellerRepository sellerRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.sellerRepository = sellerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void create(CreatePostRequest postRequest) {
        var post = PostFactory.create(postRequest);
        var seller = sellerRepository.find(SellerFactory.create(post.getUserId().toString()));
        if(seller == null)throw new IllegalArgumentException("not found seller");
        if(postRepository.create(post))return;
        throw new IllegalArgumentException("post Already Exist");
    }

    @Override
    public PostsResponse listFollowedBy(String userId) throws UserNotFound {
        var user  = userRepository.find(UserFactory.create(userId));
        if(user == null)throw new UserNotFound(userId);
        var listOfPosts = postRepository.listFollowedBy(user);
        var listOfPostResponse = listOfPosts.stream().map(PostResponseMapper::make).collect(Collectors.toList());
        return new PostsResponse(user.getId(),listOfPostResponse);
    }
}
