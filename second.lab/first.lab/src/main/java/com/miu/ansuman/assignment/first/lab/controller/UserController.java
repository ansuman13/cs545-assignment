package com.miu.ansuman.assignment.first.lab.controller;

import com.miu.ansuman.assignment.first.lab.domain.User;
import com.miu.ansuman.assignment.first.lab.dto.response.PostDto;
import com.miu.ansuman.assignment.first.lab.dto.response.UserDto;
import com.miu.ansuman.assignment.first.lab.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> users() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findUser(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDto user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    //    localhost:8080/users/1/posts
    @GetMapping("/{id}/posts")
    public List<PostDto> getAllUserPosts(@PathVariable int id) {
        return userService.getUserPosts(id);
    }

    @GetMapping("/get-user-with-more-than-one-post")
    public List<UserDto> userWithMorethanOnePost() {
        return userService.getUserWithMorethanOnePost();
    }


}
