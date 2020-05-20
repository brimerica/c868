package com.example.c868.service;

import com.example.c868.model.CallRecord;
import com.example.c868.model.Comment;
import com.example.c868.repositories.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void verifyCommentsByCallRecordId() {

        Long callRecordId = 17L;
        int expected = 3;
        int actual;

        List<Comment> commentList = new ArrayList<>();
        commentList = commentRepository.findCommentsByCallRecord_Id(callRecordId);
        actual = commentList.size();
        assertEquals(expected, actual, "Total Size of the list of all comments" +
                                                        " returned by specific Call Record Id");

        System.out.println();
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + actual);
    }
}