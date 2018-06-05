package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.Entity.Visitor;
import com.example.demo.Service.userService;
import com.example.demo.Service.visitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by ggg on 2018/5/28.
 * 对登录、注册数据进行检测
 */
@Controller
public class checkNum {

    @Autowired
    private userService userService;
    @Autowired
    private visitorService visitorService;

    /*
     * 检查注册信息的用户名是否存在，同时返回到前台
     */
    @RequestMapping("/check")
    public void checkUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取传来的account值
        String name = request.getParameter("account");
        //传来的accout是以"account=XXX"的形式，所以我们要截取"="后面的即可。
        String tmp=name.substring(8);

        System.out.println("---"+tmp);

        //根据用户名获取所有用户
        List<User> users = userService.findUserByName(tmp);

        //标记当前账号是否存在
        //  1-不存在   0-存在
        boolean flag = true;

        if (users.size()!=0) {
            flag = false;
        }

        //设置编码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //账号已存在
        if (flag==false) {
            System.out.println("error");
            out.println("<font color='red'>该帐号已经存在，请重新输入!</font>");
        } else { //账号不存在
            System.out.println("success");
            out.println("<font color='green'>恭喜您，该帐号可以使用!</font>");
        }
        out.flush();
        out.close();
    }

    /*
     *  检查登录数据
     */
    @RequestMapping("/checkLogin")
    public String checkLogin(User user, Map<String,String> model, HttpSession session) throws Exception{

        String name=user.getU_name();
        String passwd=user.getU_passwd();
        session.setAttribute("username", name);
        List<User> users = userService.findUserByName(name);


        int flag=0;
        for (User u:users) {
            if ((u.getU_passwd()).equals(passwd)) {
                flag=1;
            }
        }
        if (flag!=0) {  //登录成功

            //添加访客
            Visitor visitor = new Visitor();
            visitor.setV_name(name);
            // System.out.println("vistor id:"+visitor.getV_id()+"  vistor name:"+visitor.getV_name());
            visitorService.insertVisitor(visitor);

            //返回main.html
            return "redirect:/main";
        } else {    //登录失败
            System.out.println("error");
            model.put("error", "密码不正确");
            //out.write("");

            //用户或密码错误
            //返回login.html页面
            return "login";
        }
    }

    /*
     * 退出当前账号
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {

        session.setAttribute("username", "");

        //返回login页面
        return "login";
    }
}
