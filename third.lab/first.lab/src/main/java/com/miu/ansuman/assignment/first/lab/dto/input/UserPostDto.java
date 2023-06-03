package com.miu.ansuman.assignment.first.lab.dto.input;

import com.miu.ansuman.assignment.first.lab.domain.User;
import lombok.Data;

@Data
public class UserPostDto {

    private String title;
    private String content;
    private String author;
    private User user_id;
}
