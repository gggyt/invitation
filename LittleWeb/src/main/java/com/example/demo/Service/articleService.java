package com.example.demo.Service;

import com.example.demo.Entity.Article;

import java.util.List;

/**
 * Created by ggg on 2018/5/29.
 */
public interface articleService {
    //添加一个帖子
    public void addArticle(Article article);
    //获取所有帖子
    public List<Article> findAll();
    //通过主键获取帖子
    public Article findById(int id);
    //返回当前帖子及下面所有评论
    public List<Article> findAllArticleCommentById(int id);
    //获取所有帖子数量
    public int getAllArticleNum(String name);
    //获取某页帖子
    public List<Article> findByBeginAndNum(int begin, int num);
    //获取所有帖子的数量
    public int getAllNum();
    //根据id删除帖子
    public void deleteById(int id);
    //返回当前页面的所有帖子
    public List<Article> findByBeginAndNumAndAuthor(String name, int begin, int num);

    public List<Article> findArticleByUsernameOrDateOrTitle(String s);

    public int getArticleNumberByUsernameOrDateOrTitle(String s);

    List<Article> findSearchArticleByBeginAndNum(String s, int begin, int num);

    public int maxArticleNumber();

    public Article findArticleAndCategory(int id);

    public List<Article> findTheArticleOfOneCategory(String ca_name);


    public List<Article> findTheArticleOfCategoryLimitByBeginAndNum(String ca_name, int begin, int num);
}
