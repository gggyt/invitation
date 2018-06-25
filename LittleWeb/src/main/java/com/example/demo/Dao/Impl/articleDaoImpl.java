package com.example.demo.Dao.Impl;

import com.example.demo.Dao.articleDao;
import com.example.demo.Entity.Article;
import com.example.demo.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ggg on 2018/5/29.
 */
@Repository
public class articleDaoImpl implements articleDao {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void addArticle(Article article){
        articleMapper.addArticle(article);
    }

    @Override
    public List<Article> findAll() {
        List<Article> articles = articleMapper.findAll();

        return articles;
    }

    @Override
    public Article findById(int id){
        return articleMapper.findById(id);
    }

    @Override
    public List<Article> findAllArticleCommentById(int id){
        return articleMapper.findAllArticleCommentById(id);
    }

    @Override
    public int getAllArticleNum(String name){
        return articleMapper.getAllArticleNum(name);
    }

    @Override
    public List<Article> findByBeginAndNum(int begin, int num){
        return articleMapper.findByBeginAndNum(begin, num);
    }

    @Override
    public int getAllNum(){
        return articleMapper.getAllNum();
    }

    @Override
    public void deleteById(int id){
        articleMapper.deleteById(id);
    }

    @Override
    public List<Article> findByBeginAndNumAndAuthor(String name, int begin, int num){
        return articleMapper.findByBeginAndNumAndAuthor(name, begin, num);
    }

    @Override
    public List<Article> findArticleByUsernameOrDateOrTitle(String s) {

        return articleMapper.findArticleByUsernameOrDateOrTitle(s);
    }

    @Override
    public int getArticleNumberByUsernameOrDateOrTitle(String s){
        return articleMapper.getArticleNumberByUsernameOrDateOrTitle(s);
    }

    @Override
    public List<Article> findSearchArticleByBeginAndNum(String s, int begin, int num){
        return articleMapper.findSearchArticleByBeginAndNum(s, begin, num);
    }

    @Override
    public int maxArticleNumber(){
        return articleMapper.maxArticleNumber();
    }

    @Override
    public Article findArticleAndCategory(int id){
        return articleMapper.findArticleAndCategory(id);
    }

    @Override
    public List<Article> findTheArticleOfOneCategory(String ca_name){
        return articleMapper.findTheArticleOfOneCategory(ca_name);
    }

    @Override
    public List<Article> findTheArticleOfCategoryLimitByBeginAndNum(String ca_name, int begin, int num){
        return articleMapper.findTheArticleOfCategoryLimitByBeginAndNum(ca_name, begin, num);
    }
}
