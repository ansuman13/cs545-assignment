package com.miu.ansuman.assignment.first.lab.util;

import com.miu.ansuman.assignment.first.lab.domain.User;
import com.miu.ansuman.assignment.first.lab.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class StaticContext {

    private final UserRepo usersRepository;

    public User getCurrentUser(){
        var user = usersRepository.findById(2);
        if (user.isPresent()){
            return user.get();
        }
        return null;
    }

}