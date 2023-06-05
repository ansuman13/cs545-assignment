package com.miu.ansuman.assignment.first.lab.service.impl;

import com.miu.ansuman.assignment.first.lab.repo.CommentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl {

    private CommentRepo commentRepo;
    private ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepo cr, ModelMapper modelMapper){
        this.commentRepo = cr;
        this.modelMapper = modelMapper;
    }





}
