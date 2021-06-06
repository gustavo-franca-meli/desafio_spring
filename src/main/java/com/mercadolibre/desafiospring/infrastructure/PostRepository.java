package com.mercadolibre.desafiospring.infrastructure;

import com.mercadolibre.desafiospring.aplication.requests.OrderPost;
import com.mercadolibre.desafiospring.aplication.response.PostsResponse;
import com.mercadolibre.desafiospring.domain.Post;
import com.mercadolibre.desafiospring.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    boolean create(Post post);


    List<Post> listFollowedBy(User user, Optional<OrderPost> order);
}
