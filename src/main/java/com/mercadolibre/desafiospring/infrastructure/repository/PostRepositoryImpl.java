package com.mercadolibre.desafiospring.infrastructure.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mercadolibre.desafiospring.aplication.requests.OrderPost;
import com.mercadolibre.desafiospring.domain.Post;
import com.mercadolibre.desafiospring.domain.PromoPost;
import com.mercadolibre.desafiospring.domain.User;
import com.mercadolibre.desafiospring.domain.exception.RepositoryNotAvailable;
import com.mercadolibre.desafiospring.infrastructure.PostRepository;
import com.mercadolibre.desafiospring.infrastructure.database.JsonDb;
import com.mercadolibre.desafiospring.infrastructure.entity.PostData;
import com.mercadolibre.desafiospring.infrastructure.mapper.PostMapper;
import com.mercadolibre.desafiospring.infrastructure.mapper.PromoPostMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl extends JsonDb<PostData> implements PostRepository  {
    private static  final TypeReference<List<PostData>> typeRef = new TypeReference<>(){};
    public PostRepositoryImpl() throws RepositoryNotAvailable {
        super("posts", typeRef);
    }

    @Override
    public boolean create(Post post) {
        try {
            var posts = this.retrieve();
            var PostAlreadyExist = posts.stream().anyMatch(p -> p.getId().equals(post.getId()));
            if(PostAlreadyExist)return false;
            var postData = PostMapper.toData(post);
            postData.setPostedAt(LocalDateTime.now());
            posts.add(postData);
            this.update(posts);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean create(PromoPost post) {
        try {
            var posts = this.retrieve();
            var PostAlreadyExist = posts.stream().anyMatch(p -> p.getId().equals(post.getId()));
            if(PostAlreadyExist)return false;
            var postData = PromoPostMapper.toData(post);
            postData.setPostedAt(LocalDateTime.now());
            posts.add(postData);
            this.update(posts);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Post> listFollowedBy(User user,Optional<OrderPost> order) {
        try {
            var posts = this.retrieve();
            var followingSellerList = user.getFollowing();
            var maxDate = LocalDateTime.now().minusWeeks(2);


            var postsFollowed = posts.stream().filter(p ->  !p.getHasPromo() && p.getPostedAt().compareTo(maxDate) > -1  && followingSellerList.stream()
                    .anyMatch(
                            s -> s.getId().equals(p.getUserId()
                            )
                    )
            ).collect(Collectors.toList());
            return postsFollowed.stream().sorted(Comparator.comparing(PostData::getPostedAt,order.isPresent() && order.get().equals(OrderPost.date_desc)?Comparator.naturalOrder():Collections.reverseOrder()))
                    .map(PostMapper::toModel)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Integer countPromoPost(User user) {
        try {
            var posts = this.retrieve();

        return posts.stream().filter(p -> p.getHasPromo() && p.getUserId().equals(user.getId())).collect(Collectors.toList()).size();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
