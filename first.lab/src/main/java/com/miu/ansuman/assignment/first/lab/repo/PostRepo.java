package com.miu.ansuman.assignment.first.lab.repo;

import com.miu.ansuman.assignment.first.lab.domain.Post;
import com.miu.ansuman.assignment.first.lab.dto.response.PostDto;

import java.util.List;

public interface PostRepo {

    public List<Post> findAll();

    public Post getById(int id);

    public void save(Post p);

    public void deletePost(int id);

    public void update(int id, Post p);

    List<Post> findByAuthor(String author);
}
