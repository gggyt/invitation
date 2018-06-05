package com.example.demo.mapper;

import com.example.demo.Entity.Comment;

import java.util.List;

/**
 * Created by ggg on 2018/5/29.
 */
public interface CommentMapper {
    void addComment(Comment comment);
    List<Comment> findCommentById(int id);
    List<Comment> findCommentByPId(int id);
    int finAllNumByName(String name);
    void deleteByWaid(int id);
    void deleteById(int id);
    void deleteByPId(int id);
}
