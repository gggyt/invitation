package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ggg on 2018/5/28.
 * 对用户进行管理
 */
@Controller
public class userController {
    @Autowired
    private userService userService;

    /*
     * 添加用户
     */
    @RequestMapping("/addUser")
    public String addUser(User user) throws Exception {

        System.out.println("name:"+user.getU_name()+" passwd:"+user.getU_passwd());

        userService.addUser(user);

        return "login";
    }
}
