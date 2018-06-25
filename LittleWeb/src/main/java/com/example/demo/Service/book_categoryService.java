package com.example.demo.Service;

import com.example.demo.Entity.Category;

/**
 * Created by ggg on 2018/6/15.
 */
public interface book_categoryService {
    public void insertBookAndCategory(int id, String ca_name);

    public void updateBookAndCategoryToweifenlei(Category category);

    public void deleteMyArticleNookCategory(int aid);

    public void deleteOneCategoryOfArticle(int id, String ca_name);
}
