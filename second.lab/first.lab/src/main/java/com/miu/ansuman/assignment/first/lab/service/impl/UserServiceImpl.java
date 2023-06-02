package com.miu.ansuman.assignment.first.lab.service.impl;

import com.miu.ansuman.assignment.first.lab.domain.Post;
import com.miu.ansuman.assignment.first.lab.domain.User;
import com.miu.ansuman.assignment.first.lab.dto.response.PostDto;
import com.miu.ansuman.assignment.first.lab.dto.response.UserDto;
import com.miu.ansuman.assignment.first.lab.repo.UserRepo;
import com.miu.ansuman.assignment.first.lab.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream()
                .map((user) -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(int id) {
        Optional<User> userFound = userRepo.findById(id);
        if (userFound.isEmpty()) {
            return null;
        }
        return modelMapper.map(userFound.get(), UserDto.class);
    }

    @Override
    public void save(UserDto user) {
        userRepo.save(modelMapper.map(user, User.class));
    }

    @Override
    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<PostDto> getUserPosts(int userId) {
        User user = userRepo.getById(userId);
        List<Post> userPosts = user.getPost();
        return userPosts.stream().map((p) -> modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUserWithMorethanOnePost() {
        List<User> users = userRepo.findUsersWithMultiplePosts();
        return users.stream().map((u) -> modelMapper.map( u, UserDto.class)).collect(Collectors.toList());
    }


}
