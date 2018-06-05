package com.example.demo.Service;

import com.example.demo.Entity.Comment;

import java.util.List;

/**
 * Created by ggg on 2018/5/29.
 */
public interface commentService {
    //添加评论
    public void addComment(Comment comment);
    //根据文章a_id查找所有的评论
    public List<Comment> findCommentById(int id);
    //根据p_id查找当前p_id=id的所有评论
    public List<Comment> findCommentByPId(int id);
    //返回当前用户的所有评论数
    public int finAllNumByName(String name);
    //根据文章的a_id删除所有评论
    public void deleteByWaid(int id);
    //根据主键删除评论
    public void deleteById(int id);
    //根据p_id删除所有评论
    public  void deleteByPId(int id);
}
