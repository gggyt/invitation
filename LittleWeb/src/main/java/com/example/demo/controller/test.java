package com.example.demo.controller;

import com.example.demo.Entity.Article;
import com.example.demo.Entity.Comment;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ggg on 2018/5/29.
 */
@Controller
public class test {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping("/test")
    public String test() {
        List<Article> article=articleMapper.findAllArticleCommentById(11);
        List<Comment> comments=commentMapper.findCommentById(11);
        System.out.println(article.size());
        System.out.println(comments.size());

        return "login";
    }
    @RequestMapping("/test2")
    public String tes2t() {

        return "showmoret";
    }
}
