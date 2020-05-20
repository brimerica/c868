package com.example.c868.repositories;

import com.example.c868.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findCommentsByCallRecord_Id(Long callRecordId);

}
