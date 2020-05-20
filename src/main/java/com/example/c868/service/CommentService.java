package com.example.c868.service;

import com.example.c868.model.Comment;
import com.example.c868.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByCallRecordId(Long callRecordId){
        List<Comment> comments = new ArrayList<Comment>();

        return comments = commentRepository.findCommentsByCallRecord_Id(callRecordId);

    }

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

//    public void saveCommentsByCallRecordId(Long callRecordId){
//
//        commentRepository.saveAll(getCommentsByCallRecordId(callRecordId));
//    }

}
