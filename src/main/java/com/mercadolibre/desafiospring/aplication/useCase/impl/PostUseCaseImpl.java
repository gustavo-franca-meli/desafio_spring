package com.mercadolibre.desafiospring.aplication.useCase.impl;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;
import com.mercadolibre.desafiospring.aplication.requests.CreatePromoPostRequest;
import com.mercadolibre.desafiospring.aplication.requests.OrderPost;
import com.mercadolibre.desafiospring.aplication.response.*;
import com.mercadolibre.desafiospring.aplication.useCase.PostUseCase;
import com.mercadolibre.desafiospring.domain.exception.PostAlreadyExistException;
import com.mercadolibre.desafiospring.domain.exception.SellerNotFoundException;
import com.mercadolibre.desafiospring.domain.exception.UserNotFoundException;
import com.mercadolibre.desafiospring.domain.factories.PostFactory;
import com.mercadolibre.desafiospring.domain.factories.PromoPostFactory;
import com.mercadolibre.desafiospring.domain.factories.SellerFactory;
import com.mercadolibre.desafiospring.domain.factories.UserFactory;
import com.mercadolibre.desafiospring.infrastructure.PostRepository;
import com.mercadolibre.desafiospring.infrastructure.SellerRepository;
import com.mercadolibre.desafiospring.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
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
    public void create(CreatePostRequest postRequest) throws SellerNotFoundException, PostAlreadyExistException {
        var post = PostFactory.create(postRequest);
        var seller = sellerRepository.find(SellerFactory.create(post.getUserId().toString()));
        if(seller == null)throw new SellerNotFoundException(post.getUserId().toString());
        if(postRepository.create(post))return;
        throw new PostAlreadyExistException(post.getId().toString());
    }

    @Override
    public void create(CreatePromoPostRequest promoPost) throws SellerNotFoundException, PostAlreadyExistException {
        var post = PromoPostFactory.create(promoPost);
        var seller = sellerRepository.find(SellerFactory.create(post.getUserId().toString()));
        if(seller == null)throw new SellerNotFoundException(post.getUserId().toString());
        if(postRepository.create(post))return;
        throw new PostAlreadyExistException(post.getId().toString());
    }


    @Override
    public PostsResponse listFollowedBy(String userId, Optional<OrderPost> order) throws UserNotFoundException {
        var user  = userRepository.find(UserFactory.create(userId));
        if(user == null)throw new UserNotFoundException(userId);
        var listOfPosts = postRepository.listFollowedBy(user,order);
        var listOfPostResponse = listOfPosts.stream().map(PostResponseMapper::make).collect(Collectors.toList());
        return new PostsResponse(user.getId(),listOfPostResponse);
    }

    @Override
    public CountPromoPostsResponse countPromoPosts(String userId) throws SellerNotFoundException {
        var user  = sellerRepository.find(SellerFactory.create(userId));
        if(user == null)throw new SellerNotFoundException(userId);
        return new CountPromoPostsResponse(user.getId(),user.getName(),postRepository.countPromoPost(user));
    }

    @Override
    public PromoPostsResponse listPromoPost(String userId, Optional<OrderPost> order) throws  SellerNotFoundException {
        var user  = sellerRepository.find(SellerFactory.create(userId));
        if(user == null)throw new SellerNotFoundException(userId);
        var listOfPosts = postRepository.listPromoPost(user,order);
        var listOfPostResponse = listOfPosts.stream().map(PromoPostResponseMapper::make).collect(Collectors.toList());
        return new PromoPostsResponse(user.getId(),user.getName(),listOfPostResponse);
    }

}
