package com.example.demo.Dao.Impl;

import com.example.demo.Dao.book_categoryDao;
import com.example.demo.Entity.Category;
import com.example.demo.mapper.book_categoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ggg on 2018/6/15.
 */
@Repository
public class book_categoryDaoImpl implements book_categoryDao {

    @Autowired
    private book_categoryMapper book_categoryMapper;


    @Override
    public void insertBookAndCategory(int id, String ca_name) {
        book_categoryMapper.insertBookAndCategory(id, ca_name);
    }

    @Override
    public void updateBookAndCategoryToweifenlei(Category category){
        book_categoryMapper.updateBookAndCategoryToweifenlei(category);
    }

    @Override
    public void deleteMyArticleNookCategory(int aid){
        book_categoryMapper.deleteMyArticleNookCategory(aid);
    }

    @Override
    public void deleteOneCategoryOfArticle(int id, String ca_name){
        book_categoryMapper.deleteOneCategoryOfArticle(id, ca_name);
    }
}
