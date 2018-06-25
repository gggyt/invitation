package com.example.demo.mapper;

import java.util.List;
import com.example.demo.Entity.*;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by ggg on 2018/6/15.
 */
@Mapper
public interface CategoryMapper {
    List<Category> findAllCategory();
    List<Category> getAllCategories();
    void insertOneCategory(Category category);

    void deleteOneCategory(Category category);

    void updateOneCategoryToWeiFenlei(Category category);
}
