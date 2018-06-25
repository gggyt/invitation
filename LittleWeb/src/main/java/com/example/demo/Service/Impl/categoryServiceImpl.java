package com.example.demo.Service.Impl;

import com.example.demo.Entity.Category;
import com.example.demo.Dao.*;
import com.example.demo.Service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ggg on 2018/6/15.
 */
@Service
public class categoryServiceImpl implements categoryService {
    @Autowired
    private categoryDao categoryDao;

    @Override
    public List<Category> findAllCategory(){
        return categoryDao.findAllCategory();
    }

    @Override
    public List<Category> getAllCategories(){
        return categoryDao.getAllCategories();
    }

    @Override
    public void insertOneCategory(Category category){
        categoryDao.insertOneCategory(category);
    }

    @Override
    public void deleteOneCategory(Category category){
        categoryDao.deleteOneCategory(category);
    }

    @Override
    public void updateOneCategoryToWeiFenlei(Category category) {
        categoryDao.updateOneCategoryToWeiFenlei(category);
    }

}
