package com.mercadolibre.desafiospring.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mercadolibre.desafiospring.domain.Post;
import com.mercadolibre.desafiospring.infrastructure.PostRepository;
import com.mercadolibre.desafiospring.infrastructure.database.JsonDb;
import com.mercadolibre.desafiospring.infrastructure.entity.PostData;
import com.mercadolibre.desafiospring.infrastructure.mapper.PostMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class PostRepositoryImpl extends JsonDb<PostData> implements PostRepository  {
    private static  TypeReference<List<PostData>> typeRef = new TypeReference<>(){};
    public PostRepositoryImpl() throws IOException {
        super("posts", typeRef);
    }

    @Override
    public boolean create(Post post) {
        try {
            var posts = this.retrieve();
            var PostAlreadyExist = posts.stream().anyMatch(p -> p.getId().equals(post.getId()));
            if(PostAlreadyExist)return false;

            posts.add(PostMapper.toData(post));
            this.update(posts);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
