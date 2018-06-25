package com.example.demo.controller;

import com.example.demo.Entity.Article;
import com.example.demo.Entity.Category;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ggg on 2018/5/28.
 * 视图管理
 */
@Controller
public class viewController {

    @Autowired
    private visitorService visitorService;
    @Autowired
    private articleService articleService;
    @Autowired
    private commentService commentService;
    @Autowired
    private categoryService categoryService;
    @Autowired
    private fansService fansService;

    /*
     * 返回登录页面
     */
    @RequestMapping("/")
    public String login1() {
        return "login";
    }

    /*
     * 返回登录页面
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /*
     * 返回注册页面
     */
    @RequestMapping("/newUser")
    public String newUser() {
        return "register";
    }

    /*
     * 返回main.html
     */
    @RequestMapping("/main")
    public String main(HttpSession session,Model model) {

        //返回前台
        String name = (String)session.getAttribute("username");
        System.out.println("name:"+name);
        int num=visitorService.findAllNum();
        model.addAttribute("sum", num);
        model.addAttribute("name", name);
        int sumArticle = articleService.getAllArticleNum(name);
        model.addAttribute("sumArticle", sumArticle);
        int sumComment = commentService.finAllNumByName(name);
        model.addAttribute("sumComment", sumComment);
        int fansNum = fansService.getAllFansNum(name);
        model.addAttribute("fansNum", fansNum);

        List<Category> categorys = categoryService.findAllCategory();

        model.addAttribute("categorys", categorys);

        System.out.println("main执行完毕");

        return "main";
    }

    //添加帖子，返回添加页面
    @RequestMapping("/addTitle")
    public String addTitle(Model model) {
        List<Category> allCategories = categoryService.findAllCategory();
        for (Category ca: allCategories) {
            System.out.println(ca);
        }
        model.addAttribute("allCategories", allCategories);
        return "make";
    }

    /*
     * 返回show.html
     */
    @RequestMapping("/show")
    public String show() {
        return "show";
    }

    /*
     * 显示当前帖子的所有信息
     * 返回aboutArticle.html
     */
    @RequestMapping("/aboutArticle/{begin}")
    public String aboutArticle(@PathVariable("begin") String begin,HttpSession session, Model model) {

        int pageSize=5;
        int beginNum = Integer.parseInt(begin);

        String name=(String) session.getAttribute("username");

        //所有页面总数
        int pageNum=0;
        int allArticleNum = articleService.getAllArticleNum(name);
        pageNum = allArticleNum/pageSize;
        if (allArticleNum%pageSize!=0) {
            pageNum++;
        }
        System.out.println("pageNum:"+pageNum);
        model.addAttribute("pageNum", pageNum);

        List<Article> articles = articleService.findByBeginAndNumAndAuthor(name, Math.max((beginNum-1)*pageSize,0), pageSize);
        model.addAttribute("articles", articles);

        return "aboutArticle";
    }
}
