package com.miu.ansuman.assignment.first.lab.repo;

import com.miu.ansuman.assignment.first.lab.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo  extends JpaRepository<Comment, Long> {
}
