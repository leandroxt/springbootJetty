package com.project.app.services;

import com.project.app.domain.Post;
import com.project.app.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Date;

/**
 * Created by leandro on 12/06/16.
 */
@Service
public class PostService {

    private SecureRandom random = new SecureRandom();

    @Autowired
    private Environment environment;

    @Autowired
    private PostRepository postRepository;

    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    public Post create(MultipartFile file, Post post) {
        String filename = file.getOriginalFilename();
        String newFilename = randomString(filename);
        String directory = environment.getProperty("app.path.uploadFile");
        String filepath = Paths.get(directory, newFilename).toString();

        try {
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(filepath)));

            stream.write(file.getBytes());
            stream.close();

            post.setPicture(newFilename);
            post.setPostDate(new Date());
            postRepository.save(post);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return post;
    }

    private String randomString(String filename) {
        String[] fileExtension = filename.split("\\.");
        return new BigInteger(130, random).toString(32).concat("." + fileExtension[fileExtension.length - 1]);
    }
}
