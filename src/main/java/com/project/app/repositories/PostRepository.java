package com.project.app.repositories;

import com.project.app.domain.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by leandro on 12/06/16.
 */
@Component
public class PostRepository {

    private static List<Post> repository;

    static {
        repository = new ArrayList<>();
        Post post = new Post("idHash", "Nice title", "Nice text", new Date());
        repository.add(post);
    }

    public List<Post> getAll() {
        return repository;
    }
}
