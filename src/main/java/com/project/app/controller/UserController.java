package com.project.app.controller;

import com.project.app.domain.User;
import com.project.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by leandro on 11/07/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setProductService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    ResponseEntity<?> get(@PathVariable String userId) {
        User user = userService.findById(Long.valueOf(userId));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
    ResponseEntity create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json; charset=UTF-8")
    ResponseEntity<?> update(@RequestBody User u) {
        User user = userService.update(u);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    ResponseEntity<?> delete(@PathVariable String userId) {
        userService.delete(Long.valueOf(userId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
