package com.project.app.services;

import com.project.app.domain.Post;

import java.util.List;

/**
 * Created by leandro on 12/06/16.
 */
public interface PostService {

    Post findById(String id);

    List<Post> getAll();

    Post add(Post post);

    Post update(Post post);

    void delete(Post post);

}
