package com.miu.ansuman.assignment.first.lab.service;

import com.miu.ansuman.assignment.first.lab.domain.Post;
import com.miu.ansuman.assignment.first.lab.dto.response.PostDto;
import com.miu.ansuman.assignment.first.lab.dto.response.PostDtoV2;

import java.util.List;

public interface PostService {

    public List<PostDto> findall();
    public List<PostDtoV2> findallV2();



    PostDto getById(int id);

    public void save(PostDto p);

    public void deletePost(int id);

    public void updatePost(int id, PostDto p);

    List<PostDto> findByAuthor(String author);

    List<PostDto> findAllPostByTitle(String title);


}
