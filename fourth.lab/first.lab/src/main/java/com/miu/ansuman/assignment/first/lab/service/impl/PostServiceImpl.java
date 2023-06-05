package com.miu.ansuman.assignment.first.lab.service.impl;

import com.miu.ansuman.assignment.first.lab.domain.Post;
import com.miu.ansuman.assignment.first.lab.dto.response.PostDto;
import com.miu.ansuman.assignment.first.lab.dto.response.PostDtoV2;
import com.miu.ansuman.assignment.first.lab.repo.PostRepo;
import com.miu.ansuman.assignment.first.lab.service.PostService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> findall() {
        return postRepo.findAll()
                .stream()
                .map((post)-> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDtoV2> findallV2() {
        return postRepo.findAll()
                .stream()
                .map((post)-> modelMapper.map(post, PostDtoV2.class)
                ).collect(Collectors.toList());
    }

    @Override
    public PostDto getById(int id) {
        return modelMapper.map(postRepo.getById(id), PostDto.class);

    }

    @Override
    public void save(PostDto p) {
//        Post newPost = new Post(p.getId(), p.getTitle(), p.getContent(), p.getAuthor());
        Post newPost = modelMapper.map(p, Post.class);
        postRepo.save(newPost);
    }

    @Override
    public void deletePost(int id) {
//        postRepo.deletePost(id);
    }

    @Override
    public void updatePost(int id, PostDto p) {
//        postRepo.update(id, modelMapper.map(p, Post.class));
    }

    @Override
    public List<PostDto> findByAuthor(String author) {
        return null;
//        return postRepo.findByAuthor(author).stream().map((post) -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findAllPostByTitle(String title) {
        return postRepo.findAllByTitle(title).
                stream().
                map((p)-> modelMapper.map(p, PostDto.class)).
                collect(Collectors.toList());
    }


}
