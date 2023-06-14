package com.miu.ansuman.assignment.first.lab.service;

import com.miu.ansuman.assignment.first.lab.domain.User;
import com.miu.ansuman.assignment.first.lab.dto.response.PostDto;
import com.miu.ansuman.assignment.first.lab.dto.response.UserDto;

import java.util.List;
public interface UserService {
    List<UserDto> findAll();

    UserDto findById(int id);

    void save(UserDto d);

    void deleteUserById(int id);

    List<PostDto> getUserPosts(int userId);

    List<UserDto> getUserWithMorethanOnePost();

    List<UserDto> getUserWithMorethanNPost(int n);
}
