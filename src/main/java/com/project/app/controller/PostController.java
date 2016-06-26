package com.project.app.controller;

import com.project.app.domain.Post;
import com.project.app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by leandro on 12/06/16.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAll() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ResponseEntity<?> getById(@PathVariable String id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
    ResponseEntity<?> add(@RequestBody Post post) {
        return new ResponseEntity<>(postService.add(post), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json; charset=UTF-8")
    ResponseEntity<?> update(@RequestBody Post post) {
        return new ResponseEntity<>(postService.update(post), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    ResponseEntity<?> delete(@PathVariable("id") String id) {
        Post post = postService.findById(id);
        postService.delete(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

}
