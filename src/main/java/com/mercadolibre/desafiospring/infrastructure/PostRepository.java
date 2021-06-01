package com.mercadolibre.desafiospring.infrastructure;

import com.mercadolibre.desafiospring.domain.Post;

public interface PostRepository {
    boolean create(Post post);
}
