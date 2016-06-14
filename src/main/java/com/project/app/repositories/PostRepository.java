package com.project.app.repositories;

import com.project.app.domain.Post;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by leandro on 12/06/16.
 */
@Component
public class PostRepository {

    private static List<Post> repository = new ArrayList<>();

    public Post findById(String id) {
        Optional<Post> p = repository.stream().filter(pt -> pt.getId().equals(id)).findFirst();
        return p.get();
    }

    public List<Post> getAll() {
        return repository;
    }

    public Post add(Post post) {
        post.setId(new BigInteger(130, new SecureRandom()).toString(32));
        post.setDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        repository.add(post);
        return post;
    }

    public Post update(Post post) {
        repository.forEach(p -> {
            if (p.getId().equals(post.getId())) {
                repository.remove(p);
            }
        });
        repository.add(post);
        return post;
    }

    public void delete(Post post) {
        repository.remove(post);
    }
}
