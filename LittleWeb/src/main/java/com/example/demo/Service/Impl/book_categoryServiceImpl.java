package com.example.demo.Service.Impl;

import com.example.demo.Dao.book_categoryDao;
import com.example.demo.Entity.Category;
import com.example.demo.Service.book_categoryService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ggg on 2018/6/15.
 */
@Service
public class book_categoryServiceImpl implements book_categoryService {

    @Autowired
    private book_categoryDao book_categoryDao;

    @Override
    public void insertBookAndCategory(int id, String ca_name){
        book_categoryDao.insertBookAndCategory(id, ca_name);
    }

    @Override
    public void updateBookAndCategoryToweifenlei(Category category){
        book_categoryDao.updateBookAndCategoryToweifenlei(category);
    }

    @Override
    public void deleteMyArticleNookCategory(int aid){
        book_categoryDao.deleteMyArticleNookCategory(aid);
    }

    @Override
    public void deleteOneCategoryOfArticle(int id, String ca_name){
        book_categoryDao.deleteOneCategoryOfArticle(id, ca_name);
    }
}
