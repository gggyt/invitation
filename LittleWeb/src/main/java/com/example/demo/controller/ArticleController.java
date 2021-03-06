package com.example.demo.controller;

import com.example.demo.Entity.*;
import com.example.demo.Service.articleService;
import com.example.demo.Service.book_categoryService;
import com.example.demo.Service.commentService;
import com.example.demo.mapper.book_categoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ggg on 2018/5/29.
 * 对帖子操作进行管理
 */
@Controller
public class ArticleController {
    @Autowired
    private articleService articleService;
    @Autowired
    private commentService commentService;
    @Autowired
    private book_categoryService book_categoryService;
    /*
        添加帖子
     */
    @RequestMapping("/addArticle")
    public String addArticle(Article article, @RequestParam(value = "test") String test, HttpSession session) throws Exception{

        System.out.println(test);

        //  获取当前用户名
        String author = (String)session.getAttribute("username");

        article.setA_author(author);
        article.setA_date(new Date());
        System.out.println("---:"+new Date());

        //测试输出
        //System.out.println("a_id:"+article.getA_id()+"  a_title:"+article.getA_title()+"  a_content:"+article.getA_content()+"  a_date:"+article.getA_date());

        //添加进数据库
        articleService.addArticle(article);

        //当前添加的文章的a_id
        int articleNowNumber = articleService.maxArticleNumber();

        if(test.length()==0) {
            book_categoryService.insertBookAndCategory(articleNowNumber, "未分类");
        }
        else {
            String[] categoryName = test.split(",");
            for (int i = 0; i < categoryName.length; i++) {
                System.out.println(categoryName[i]);
                book_categoryService.insertBookAndCategory(articleNowNumber, categoryName[i]);
            }

        }
        //重定向至显示页面
        return "redirect:/getPageArticle/0";
    }

    /*
    获取当前页面的帖子，显示在页面上
     */
    @RequestMapping("/getPageArticle/{begin}")
    public String getPageArticle(@PathVariable("begin") String begin,Model model) {
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
        int allArticleNum = articleService.getAllNum();

        //计算所有页数
        pageNum = allArticleNum/pageSize;
        if (allArticleNum%pageSize!=0) {
            pageNum++;
        }

        //前台显示所有页数
        model.addAttribute("pageNum", pageNum);

        //返回当前页面Article
        List<Article> articles = articleService.findByBeginAndNum(Math.max((beginNum-1)*pageSize,0), pageSize);

        //测试输出
        System.out.println("---size:"+articles.size()+"  begin:"+(beginNum-1)*pageSize);

        //前台显示当前页面的帖子
        model.addAttribute("articles", articles);

        //返回show.html
        return "show";
    }

    /*
    显示帖子更多的相关内容
     */
    @RequestMapping("/showArticle/{id}")
    public String showSrticle(@PathVariable("id") String id, HttpServletRequest request, Model model,HttpSession session) {

        //  获取当前登录用户名
        String author = (String)session.getAttribute("username");

       // System.out.println(id);
        //获取当前帖子的a_id
        int idd=Integer.parseInt(id);

        System.out.println("nowArticleid:"+idd);
       // List<Article> article = articleService.findAllArticleCommentById(idd);

        //获取当前帖子
       // Article article = articleService.findById(idd);
        Article article = articleService.findArticleAndCategory(idd);

        System.out.println(article);
        //分类列表
        List<Category> categories = article.getCategories();
        System.out.println(categories.size());

        int ii=0;
        String categoriesS = "";
        for (Category ca: categories) {
            ii++;
            if (ca.getCa_name().equals("未分类")==true) {
                continue;
            }
            categoriesS = categoriesS+ca.getCa_name();
            if (ii!=categories.size()) {
                categoriesS = categoriesS+ ",";
            }
        }
        if (categoriesS.length()==0) {
            categoriesS="未分类";
        }
        System.out.println(categoriesS);

        //获取当前帖子下的评论
        List<Comment> comments1 = commentService.findCommentById(idd);
        //获取所有评论和子评论
        List<CommentAndSon> comments = new ArrayList<CommentAndSon>();
        for (Comment com: comments1) {
            if (com.getP_id()!=0)  {
                continue;
            }
            CommentAndSon comson = new CommentAndSon();
            comson.setFComment(com);
            List<Comment> son = commentService.findCommentByPId(com.getC_id());
            comson.setSComment(son);
            comments.add(comson);
        }

        //标记当前帖子和当前用户是否是同一个人
        int flag=0;
        if (author!=null&&author.equals(article.getA_author())) {
            flag=1;
        }
        //System.out.println(comments.size());

        //前台显示
        model.addAttribute("comments", comments);
        model.addAttribute("article", article);
        model.addAttribute("flag", flag);
        model.addAttribute("categoriesS", categoriesS);

        //转至showmoret.html
        return "showmoret";
    }

    /*
    删除当前帖子
     */
    @RequestMapping("/deleteArticle/{id}")
    public String deleteArticle(@PathVariable("id") String id) {

        //获取当前帖子的a_id
        int aid = Integer.parseInt(id);

        //
        book_categoryService.deleteMyArticleNookCategory(aid);
        //根据a_id删除当前帖子
        articleService.deleteById(aid);
        //根据a_id删除当前帖子下的评论
        commentService.deleteByWaid(aid);

        //显示第一页
        return "redirect:/aboutArticle/0";
    }

    @RequestMapping("/findArticleByUsernameOrDateOrTitle")
    public String findArticleByUsernameOrDateOrTitle( Model model, HttpServletRequest request) throws Exception{


        request.setCharacterEncoding("utf-8");
        String s = request.getParameter("s");
        System.out.println("----"+s);

        List<Article> articles = articleService.findSearchArticleByBeginAndNum(s, 0, 5);

        //List<Article> articles = articleService.findArticleByUsernameOrDateOrTitle(s);

        for (Article article: articles) {
            System.out.println(article);
        }

        //前台显示当前页面的帖子
        model.addAttribute("articles", articles);

        //一页上显示的帖子个数
        int pageSize=5;

        //所有帖子总数
        int pageNum=0;
        int allArticleNum = articleService.getArticleNumberByUsernameOrDateOrTitle(s);
       //int allArticleNum = 10;
        //int allArticleNum=articles.size();
        System.out.println("allArticleNum:"+allArticleNum);
        //计算所有页数
        pageNum = allArticleNum/pageSize;
        if (allArticleNum%pageSize!=0) {
            pageNum++;
        }

        //前台显示所有页数
        model.addAttribute("pageNum", pageNum);

        model.addAttribute("s", s);
        //返回show.html
        return "showSousuo";
    }

    @RequestMapping("/deppendOnSearchPageArticle/{begin}/{s}")
    public String deppendOnSearchPageArticle(@PathVariable("begin") String begin, @PathVariable("s") String s, Model model) {

        int beginNum = Integer.parseInt(begin);
        int pageSize=5;


        System.out.println(begin+" "+s);

        List<Article> articles = articleService.findSearchArticleByBeginAndNum(s, Math.max((beginNum-1)*pageSize,0), pageSize);
        model.addAttribute("articles", articles);

        int allArticleNum = articleService.getArticleNumberByUsernameOrDateOrTitle(s);
        System.out.println("allArticleNum:"+allArticleNum);
        System.out.println("allAricle:"+allArticleNum);
        //计算所有页数
        int pageNum =0;
        pageNum = allArticleNum/pageSize;
        if (allArticleNum%pageSize!=0) {
            pageNum++;
        }

        //前台显示所有页数
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("s", s);

        return "showSousuo";
    }
}
