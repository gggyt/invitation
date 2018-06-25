package com.example.demo.controller;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.Friend;
import com.example.demo.Service.categoryService;
import com.example.demo.Service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ggg on 2018/6/15.
 */
@Controller
public class HoutaiController {

    @Autowired
    private categoryService categoryService;
    @Autowired
    private friendService friendService;

    @RequestMapping("/personMain")
    public String personMain(HttpSession session, Model model) {
        String userName = (String)session.getAttribute("username");
        model.addAttribute("username", userName);
        return "personMain";
    }

    @RequestMapping("/personCategory")
    public String personCategory(Model model) {

        List<Category> categories = categoryService.getAllCategories();

        model.addAttribute("categories", categories);

        return "personCategory";
    }

    @RequestMapping("/agreeWithAddFriend")
    public String agreeWithAddFriend(HttpSession session, Model model) {

        String username=(String)session.getAttribute("username");

        List<Friend> friends =friendService.getAllDontAgreeFriend(username);

        model.addAttribute("friends", friends);

        return "agreeWithAddFriend";
    }
}
