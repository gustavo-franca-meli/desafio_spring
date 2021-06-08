package com.mercadolibre.desafiospring.aplication.useCase;

import com.mercadolibre.desafiospring.aplication.requests.CreatePostRequest;
import com.mercadolibre.desafiospring.aplication.requests.CreatePromoPostRequest;
import com.mercadolibre.desafiospring.aplication.requests.OrderPost;
import com.mercadolibre.desafiospring.aplication.response.CountPromoPostsResponse;
import com.mercadolibre.desafiospring.aplication.response.PostsResponse;
import com.mercadolibre.desafiospring.aplication.response.PromoPostsResponse;
import com.mercadolibre.desafiospring.domain.exception.PostAlreadyExistException;
import com.mercadolibre.desafiospring.domain.exception.SellerNotFoundException;
import com.mercadolibre.desafiospring.domain.exception.UserNotFoundException;

import java.util.Optional;

public interface PostUseCase {

    void create(CreatePostRequest post) throws SellerNotFoundException, PostAlreadyExistException;
    void create(CreatePromoPostRequest promoPost) throws SellerNotFoundException, PostAlreadyExistException;
    PostsResponse listFollowedBy(String userId, Optional<OrderPost> order) throws UserNotFoundException;

    CountPromoPostsResponse countPromoPosts(String userId) throws UserNotFoundException, SellerNotFoundException;

   PromoPostsResponse listPromoPost(String userId, Optional<OrderPost> order) throws UserNotFoundException, SellerNotFoundException;
}
