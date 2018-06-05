package com.example.demo.mapper;

import com.example.demo.Entity.Article;
import com.example.demo.Entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ggg on 2018/5/29.
 */
public interface ArticleMapper {
    void addArticle(Article article);
    List<Article> findAll();
    Article findById(int id);
    List<Article> findAllArticleCommentById(int id);
    int getAllArticleNum(String name);
    List<Article> findByBeginAndNum(@Param("begin")int begin, @Param("num")int num);
    int getAllNum();
    void deleteById(int id);
    List<Article> findByBeginAndNumAndAuthor(@Param("name")String name,@Param("begin")int begin, @Param("num")int num);
}
