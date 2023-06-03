package com.miu.ansuman.assignment.first.lab.controller;

import com.miu.ansuman.assignment.first.lab.domain.Post;
import com.miu.ansuman.assignment.first.lab.dto.response.PostDto;
import com.miu.ansuman.assignment.first.lab.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/post")
@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> posts(@RequestParam(value = "author", required = false) String author) {
        return author!=null ? postService.findByAuthor(author): postService.findall();
    }

    @GetMapping(headers = {"version=v2"})
    public List<PostDto> postsV2() {
        return postService.findall();
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable int id) {
        return postService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(@RequestBody PostDto post) {
        postService.save(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable int id, @RequestBody PostDto p){
        postService.updatePost(id, p);
    }

    //8-	Make a query that will find all the posts that match a given title
    @GetMapping("/title/{title}")
    public List<PostDto> findAllPosts(@PathVariable String title){
        return postService.findAllPostByTitle(title);
    }
}
