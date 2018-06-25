package com.example.demo.Dao;

import com.example.demo.Entity.Category;

import java.util.List;

/**
 * Created by ggg on 2018/6/15.
 */
public interface categoryDao {
    public List<Category> findAllCategory();
    public List<Category> getAllCategories();
    public void insertOneCategory(Category category);

    public void deleteOneCategory(Category category);

    public void updateOneCategoryToWeiFenlei(Category category);


}
