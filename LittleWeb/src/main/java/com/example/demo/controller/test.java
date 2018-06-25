package com.example.demo.controller;

import com.example.demo.Entity.Article;
import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Friend;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.mapper.FriendMapper;
import com.example.demo.mapper.book_categoryMapper;
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
    @Autowired
    private book_categoryMapper book_categoryMapper;
    @Autowired
    private FriendMapper friendMapper;


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

//    @RequestMapping("/findCategory")
//    public String findCategory() {
//        List<Article> articles = articleMapper.findArticleAndCategory(39);
//        for (Article a: articles) {
//            System.out.println(a);
//        }
//        return "login";
//    }

    @RequestMapping("/findFriendOrNot")
    public String findFriendOrNot() {

        List<Friend> friends=friendMapper.findFriendOrNotWithOther("ergou", "xigua");
        System.out.println(friends.size());

        friends=friendMapper.findFriendOrNotWithOther("1", "2");
        System.out.println(friends.size());

        return "login";
    }

    @RequestMapping("/testFindTheArticleOfCategory")
    public String testFindTheArticleOfCategory() {

        List<Article> articles = articleMapper.findTheArticleOfOneCategory("生活");
        for (Article a: articles) {
            System.out.println(a);
        }

        return "login";
    }
}
