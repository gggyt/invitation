package com.example.demo.controller;

import com.example.demo.Entity.Article;
import com.example.demo.Entity.Category;
import com.example.demo.Service.articleService;
import com.example.demo.Service.book_categoryService;
import com.example.demo.Service.categoryService;
import com.example.demo.mapper.book_categoryMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ggg on 2018/6/15.
 */
@Controller
public class CategoryController {

    @Autowired
    private categoryService categoryService;
    @Autowired
    private book_categoryService book_categoryService;
    @Autowired
    private articleService articleService;


    @RequestMapping("/addCategory")
    public String addCategory(Category category) {

        List<Category> categories = categoryService.getAllCategories();

        int flag=0;
        for (Category ca: categories) {
            if (ca.getCa_name().equals(category.getCa_name())) {
                flag=1;  break;
            }
        }
        if (flag==0) {
            categoryService.insertOneCategory(category);
        }

        return "redirect:/personCategory";
    }

//    @RequestMapping("/deleteOneCategory/{ca_name}")
//    public String deleteOneCategory(@PathVariable("ca_name") String ca_name) {
//
//        System.out.println("category-ca_name:"+ca_name);
//
//        Category category = new Category();
//        category.setCa_name(ca_name);
//
//        System.out.println("----");
//
//        book_categoryService.updateBookAndCategoryToweifenlei(category);
//        System.out.println("----");
//       // categoryService.updateOneCategoryToWeiFenlei(category);
//        System.out.println("----");
//
//        categoryService.deleteOneCategory(category);
//
//        return "redirect:/personCategory";
//    }
    @RequestMapping("/deleteOneCategory/{ca_name}")
    public String deleteOneCategory(@PathVariable("ca_name") String ca_name) {

        System.out.println("category-ca_name:"+ca_name);

        Category category = new Category();
        category.setCa_name(ca_name);

        System.out.println("----");

        List<Article> articlesOfCategory = articleService.findTheArticleOfOneCategory(ca_name);

        for (Article article1: articlesOfCategory) {
            System.out.println(article1);
            Article article = articleService.findArticleAndCategory(article1.getA_id());

            System.out.println(article);
            //分类列表
            List<Category> categories = article.getCategories();
            System.out.println(categories.size());

            if (categories.size()==1) {
                book_categoryService.updateBookAndCategoryToweifenlei(category);
            }
            else {
                book_categoryService.deleteOneCategoryOfArticle(article.getA_id(), ca_name);
            }
        }

//        book_categoryService.updateBookAndCategoryToweifenlei(category);
//        System.out.println("----");
//       // categoryService.updateOneCategoryToWeiFenlei(category);
//        System.out.println("----");
//
        categoryService.deleteOneCategory(category);


        return "redirect:/personCategory";
    }

    @RequestMapping("/getTheArticleOfCategory/{category}/{begin}")
    public String getTheArticleOfCategory(@PathVariable("category") String category,@PathVariable("begin") String begin,Model model) {

        List<Article> articles1 = articleService.findTheArticleOfOneCategory(category);
        for (Article article: articles1){
            System.out.println(article);
        }

        //begin-当前页数

        //将string转换为int型
        int beginNum = 0;
        if (begin!=null||begin!="") {
            beginNum=Integer.parseInt(begin);
        }

        //一页上显示的帖子个数
        int pageSize=5;

        //所有帖子总数
        int pageNum=0;
        int allArticleNum = articles1.size();

        //计算所有页数
        pageNum = allArticleNum/pageSize;
        if (allArticleNum%pageSize!=0) {
            pageNum++;
        }

        //前台显示所有页数
        model.addAttribute("pageNum", pageNum);

        List<Article> articles = articleService.findTheArticleOfCategoryLimitByBeginAndNum(category, Math.max((beginNum-1)*pageSize,0), pageSize);

        //测试输出
        System.out.println("---size:"+articles.size()+"  begin:"+(beginNum-1)*pageSize);

        //前台显示当前页面的帖子
        model.addAttribute("articles", articles);
        model.addAttribute("categoryName", category);

        //返回show.html
        return "showTheArticleOfCategory";
    }
}
