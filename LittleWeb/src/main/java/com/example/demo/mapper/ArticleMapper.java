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
    List<Article> findArticleByUsernameOrDateOrTitle(@Param("s") String s);

    int getArticleNumberByUsernameOrDateOrTitle(@Param("s") String s);

    List<Article> findSearchArticleByBeginAndNum(@Param("s") String s, @Param("begin") int begin,  @Param("num") int num );
    int maxArticleNumber();

    Article findArticleAndCategory(@Param("id") int id);

    List<Article> findTheArticleOfOneCategory(@Param("ca_name") String ca_name);

    List<Article> findTheArticleOfCategoryLimitByBeginAndNum(@Param("ca_name") String ca_name, @Param("begin") int beigin, @Param("num") int num);
}
