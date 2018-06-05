package com.example.demo.Service.Impl;

import com.example.demo.Dao.commentDao;
import com.example.demo.Entity.Comment;
import com.example.demo.Service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ggg on 2018/5/29.
 */
@Service
public class commentServiceImpl implements commentService {

    @Autowired
    private commentDao commentDao;

    @Override
    public void addComment(Comment comment){
        commentDao.addComment(comment);
    }

    @Override
    public List<Comment> findCommentById(int id){
        return commentDao.findCommentById(id);
    }
    @Override
    public List<Comment> findCommentByPId(int id){
        return commentDao.findCommentByPId(id);
    }

    @Override
    public int finAllNumByName(String name){
        return commentDao.finAllNumByName(name);
    }

    @Override
    public void deleteByWaid(int id){
        commentDao.deleteByWaid(id);
    }

    @Override
    public void deleteById(int id){
        commentDao.deleteById(id);
    }

    @Override
    public  void deleteByPId(int id){
        commentDao.deleteByPId(id);
    }
}
