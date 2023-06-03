package com.miu.ansuman.assignment.first.lab.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="comment_id")
    private List<Comment> comments;

    public void addComment(Comment c){
        this.comments.add(c);
    }

}

