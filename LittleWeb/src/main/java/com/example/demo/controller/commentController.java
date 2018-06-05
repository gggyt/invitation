package com.example.demo.controller;

import com.example.demo.Entity.Comment;
import com.example.demo.Service.commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by ggg on 2018/5/29.
 * 对评论进行管理
 */
@Controller
public class commentController {

    @Autowired
    private commentService commentService;

    /*
     * 在一个帖子下面添加评论
     */
    @RequestMapping("/addComment/{id}")
    public String addComment(@PathVariable("id") String id, HttpSession session, Comment comment) {

        System.out.println(id+"  "+comment.getC_content());

        //获取到文章的id
        int idd=Integer.parseInt(id);

        //获取当前登录有户名
        String name = (String)session.getAttribute("username");
        System.out.println("username:"+name);

        //添加评论
        comment.setU_name(name);
        System.out.println("commen_u_name:"+comment.getU_name());
        comment.setC_date(new Date());
        comment.setWa_id(idd);
        commentService.addComment(comment);

        //返回当前帖子
        return "redirect:/showArticle/"+id;
    }

    /*
     * 添加评论的子评论
     */
    @RequestMapping("/addSonComment/{id}/{pid}")
    public String addSonComment(@PathVariable("id") String id, @PathVariable("pid") String pid, HttpSession session, Comment comment) {

        //获取当前登录有户名
        String name = (String)session.getAttribute("username");
        System.out.println("id:"+id+"  pid:"+pid);

        //获取文章的id
        int idd = Integer.parseInt(id);
        //获取上级评论的id
        int pidd = Integer.parseInt(pid);

        //添加评论
        comment.setWa_id(idd);
        comment.setP_id(pidd);
        comment.setU_name(name);
        comment.setC_date(new Date());
        System.out.println(comment.getC_content());
        commentService.addComment(comment);

        //返回当前帖子页面
        return "redirect:/showArticle/"+id;
    }

    /*
     * 删除评论
     */
    @RequestMapping("/deleteComment/{id}/{a_id}")
    public String deleteComment(@PathVariable("id") String id,@PathVariable("a_id") String a_id) {

        //获取当前评论id
        int idd = Integer.parseInt(id);
        //获取当前
        int a_idd = Integer.parseInt(a_id);

        //删除当前评论
        commentService.deleteById(idd);
        //删除当前评论的子评论
        commentService.deleteByPId(idd);

        //返回当前帖子页面
        return "redirect:/showArticle/"+a_idd;
    }
}
