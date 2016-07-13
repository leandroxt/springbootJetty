package com.project.app.services;

import com.project.app.domain.User;
import com.project.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by leandro on 11/07/16.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        User u = null;
        try {
            u = userRepository.findOne(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return u;
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        User obj = findById(user.getId());

        if (obj != null) {
            throw new RuntimeException("User already exists");
        }

        user.setLastAccess(new Date());
        user.setBecomeUser(new Date());

        userRepository.save(user);

        return user;
    }

    public User update(User user) {
        user.setLastAccess(new Date());
        userRepository.save(user);
        return user;
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
}
