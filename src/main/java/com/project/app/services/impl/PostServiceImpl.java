package com.project.app.services.impl;

import com.project.app.domain.Post;
import com.project.app.repositories.PostRepository;
import com.project.app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by leandro on 12/06/16.
 */
@Component
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository = new PostRepository();

    @Override
    public Post findById(String id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post add(Post post) {
        return postRepository.add(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.update(post);
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

}
