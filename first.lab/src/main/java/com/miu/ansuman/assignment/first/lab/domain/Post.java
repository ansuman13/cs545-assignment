package com.miu.ansuman.assignment.first.lab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    long id;
    String title;
    String content;
    String author;

}

