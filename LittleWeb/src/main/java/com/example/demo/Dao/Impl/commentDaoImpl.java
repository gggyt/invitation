package com.example.demo.Dao.Impl;

import com.example.demo.Dao.commentDao;
import com.example.demo.Entity.Comment;
import com.example.demo.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ggg on 2018/5/29.
 */
@Repository
public class commentDaoImpl implements commentDao {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }
    @Override
    public List<Comment> findCommentById(int id){
        return commentMapper.findCommentById(id);
    }
    @Override
    public List<Comment> findCommentByPId(int id){
        return commentMapper.findCommentByPId(id);
    }

    @Override
    public int finAllNumByName(String name){
        return commentMapper.finAllNumByName(name);
    }

    @Override
    public void deleteByWaid(int id) {
        commentMapper.deleteByWaid(id);
    }

    @Override
    public void deleteById(int id){
        commentMapper.deleteById(id);
    }

    @Override
    public  void deleteByPId(int id){
        commentMapper.deleteByPId(id);
    }
}
