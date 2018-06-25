package com.example.demo.mapper;

import com.example.demo.Entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ggg on 2018/6/15.
 */
@Mapper
public interface book_categoryMapper {
    void insertBookAndCategory(@Param("id") int id, @Param("ca_name") String ca_name);

    void updateBookAndCategoryToweifenlei(Category category);

    void deleteMyArticleNookCategory(int aid);

    int getBookCategoryNum(int aid);

    void deleteOneCategoryOfArticle(@Param("id") int id, @Param("ca_name") String ca_name);
}
