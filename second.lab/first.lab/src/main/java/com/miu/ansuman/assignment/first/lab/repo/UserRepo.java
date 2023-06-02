package com.miu.ansuman.assignment.first.lab.repo;

import com.miu.ansuman.assignment.first.lab.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE size(u.post) > 1")
    List<User> findUsersWithMultiplePosts();
}
