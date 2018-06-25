package com.example.demo.Service.Impl;

import com.example.demo.Dao.articleDao;
import com.example.demo.Entity.Article;
import com.example.demo.Service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ggg on 2018/5/29.
 */
@Service
public class articleServiceImpl implements articleService {

    @Autowired
    private articleDao articleDao;

    @Override
    public void addArticle(Article article) {
        articleDao.addArticle(article);
    }

    @Override
    public List<Article> findAll() {
        List<Article> articles = articleDao.findAll();

        return articles;
    }

    @Override
    public Article findById(int id){
        return articleDao.findById(id);
    }
    @Override
    public List<Article> findAllArticleCommentById(int id){
        return articleDao.findAllArticleCommentById(id);
    }

    @Override
    public int getAllArticleNum(String name){
        return articleDao.getAllArticleNum(name);
    }

    //获取某页文章
    @Override
     public List<Article> findByBeginAndNum(int begin, int num){
        return articleDao.findByBeginAndNum(begin, num);
    }

    //获取所有文章数量
    @Override
    public int getAllNum(){
         return articleDao.getAllNum();
    }

    @Override
    public void deleteById(int id) {
        articleDao.deleteById(id);
    }

    @Override
    public List<Article> findByBeginAndNumAndAuthor(String name, int begin, int num) {
        return articleDao.findByBeginAndNumAndAuthor(name, begin, num);
    }

    @Override
    public List<Article> findArticleByUsernameOrDateOrTitle(String s){
        return articleDao.findArticleByUsernameOrDateOrTitle(s);
    }

    @Override
    public int getArticleNumberByUsernameOrDateOrTitle(String s){
        return articleDao.getArticleNumberByUsernameOrDateOrTitle(s);
    }

    @Override
    public List<Article> findSearchArticleByBeginAndNum(String s, int begin, int num){
        return articleDao.findSearchArticleByBeginAndNum(s, begin, num);
    }

    @Override
    public int maxArticleNumber(){
        return articleDao.maxArticleNumber();
    }

    @Override
    public Article findArticleAndCategory(int id){
        return articleDao.findArticleAndCategory(id);
    }

    @Override
    public List<Article> findTheArticleOfOneCategory(String ca_name){
        return articleDao.findTheArticleOfOneCategory(ca_name);
    }

    @Override
    public List<Article> findTheArticleOfCategoryLimitByBeginAndNum(String ca_name, int begin, int num){
        return articleDao.findTheArticleOfCategoryLimitByBeginAndNum(ca_name, begin, num);
    }
}
