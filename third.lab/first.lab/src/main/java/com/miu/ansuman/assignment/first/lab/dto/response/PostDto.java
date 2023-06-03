package com.miu.ansuman.assignment.first.lab.dto.response;

import lombok.Data;

@Data
public class PostDto {
    private int id;
    private String title;
    private String content;
    private String author;
}
