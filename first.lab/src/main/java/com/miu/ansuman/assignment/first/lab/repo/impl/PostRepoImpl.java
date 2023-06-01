package com.miu.ansuman.assignment.first.lab.repo.impl;

import com.miu.ansuman.assignment.first.lab.domain.Post;
import com.miu.ansuman.assignment.first.lab.dto.response.PostDto;
import com.miu.ansuman.assignment.first.lab.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {

    private static List<Post> posts = new ArrayList<>();

    static {
        posts.add(new Post(1,"Post 1", "post one content", "Ansuman"));
        posts.add(new Post(2,"Post 2", "post two content", "Anveskha"));
        posts.add(new Post(3,"Post 3", "post three content", "Ashmita"));
        posts.add(new Post(4,"Post 4", "post four content", "Anamika"));
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post getById(int id) {
        return posts.stream().filter((p) -> p.getId() == id ).findFirst().get();
    }

    @Override
    public void save(Post p) {
        posts.add(p);
    }

    public void deletePost(int id){
        posts.removeIf((post)-> post.getId() == id);
    }

    @Override
    public void update(int id, Post p) {
        Post toUpdate = getById(id);
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getContent());
        toUpdate.setAuthor(p.getAuthor());
    }

    @Override
    public List<Post> findByAuthor(String author) {
        return posts.
                stream().
                filter((p)-> p.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

}
