package com.example.demo.Dao.Impl;

import com.example.demo.Dao.categoryDao;
import com.example.demo.Entity.Category;
import com.example.demo.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ggg on 2018/6/15.
 */
@Repository
public class categoryDaoImpl implements categoryDao {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAllCategory(){
        return categoryMapper.findAllCategory();
    }

    @Override
    public List<Category> getAllCategories(){
        return categoryMapper.getAllCategories();
    }

    @Override
    public void insertOneCategory(Category category){
        categoryMapper.insertOneCategory(category);
    }

    @Override
    public void deleteOneCategory(Category category){
        categoryMapper.deleteOneCategory(category);
    }

    @Override
    public void updateOneCategoryToWeiFenlei(Category category) {
        categoryMapper.updateOneCategoryToWeiFenlei(category);
    }
}
