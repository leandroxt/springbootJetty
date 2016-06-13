package com.project.app.controller;

import com.project.app.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
