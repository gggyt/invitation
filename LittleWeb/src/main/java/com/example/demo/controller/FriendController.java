package com.example.demo.controller;

import com.example.demo.Entity.Fans;
import com.example.demo.Entity.Friend;
import com.example.demo.Entity.User;
import com.example.demo.Service.fansService;
import com.example.demo.Service.friendService;
import com.example.demo.Service.userService;
import com.example.demo.TempEntity.friendOrNot;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;






/**
 * Created by ggg on 2018/6/16.
 */
@Controller
public class FriendController {

    @Autowired
    private userService userService;
    @Autowired
    private friendService friendService;
    @Autowired
    private fansService fansService;


    @RequestMapping("/allFriend/{begin}")
    public String allFriend(@PathVariable("begin") String begin, HttpSession session, Model model) {

        //begin-当前页数

        //将string转换为int型
        int beginNum = 0;
        if (begin!=null||begin!="") {
            beginNum=Integer.parseInt(begin);
        }

        //一页上显示的帖子个数
        int pageSize=10;

        //所有帖子总数
        int pageNum=0;
        int allUserNum = userService.getAllUserNum();

        System.out.println("allUserNum:"+allUserNum);

        //计算所有页数
        pageNum = allUserNum/pageSize;
        if (allUserNum%pageSize!=0) {
            pageNum++;
        }


        String nowUserName = (String)session.getAttribute("username");

        List<User> users = userService.getUserByLimitBeginAndNum(Math.max((beginNum-1)*pageSize,0), pageSize);

        List<friendOrNot> friendOrNotList = new ArrayList<friendOrNot>();


        for (User user: users) {

            if (nowUserName.equals(user.getU_name())==false) {
                friendOrNot friendOrNotNow = new friendOrNot();
                System.out.println(user);
                friendOrNotNow.setNowUserName(nowUserName);
                friendOrNotNow.setFriendName(user.getU_name());

                List<Friend> friends = friendService.findFriendOrNotWithOther(nowUserName, user.getU_name());
                List<Fans> fansList = fansService.isFansOrNot(nowUserName, user.getU_name());
                if (friends.size()==0) {
                    friendOrNotNow.setFriendOrNot(0);
                }
                else {
                    Friend firstFriend = friends.get(0);
                    if (firstFriend.getFriendOrNot()==1) {
                        friendOrNotNow.setFriendOrNot(1);
                    }
                    else {
                        friendOrNotNow.setFriendOrNot(2);

                    }
                }
                if (fansList.size()==0) {
                    friendOrNotNow.setFansOrNot(0);
                }
                else {
                    friendOrNotNow.setFansOrNot(1);
                }
                friendOrNotList.add(friendOrNotNow);
            }

        }

        for (friendOrNot f: friendOrNotList) {
            System.out.println(f);
        }

        model.addAttribute("friendOrNotList", friendOrNotList);
        model.addAttribute("pageNum", pageNum);

        return "allFriend";
    }

    @RequestMapping("/addFriendWithMe/{friendName}")
    public String addFriendWithMe(@PathVariable("friendName") String friendName, HttpSession session) {

        System.out.println("friendUserName:"+friendName);
        String nowUserName = (String)session.getAttribute("username");

        friendService.addFriendWithMe(nowUserName, friendName, 2);

        return "redirect:/allFriend/1";
    }

    @RequestMapping("/agreeAddFriend/{friendName}")
    public String agreeAddFriend(@PathVariable("friendName") String friendName, HttpSession session) {

        System.out.println("friendUserName:"+friendName);
        String nowUserName = (String)session.getAttribute("username");

        friendService.addSomeoneToFriend(friendName, nowUserName);
        friendService.addFriendWithMe(nowUserName, friendName, 1);

        return "redirect:/agreeWithAddFriend";
    }

   @RequestMapping("/allMyAddFriend")
    public String allMyAddFriend(HttpSession session, Model model) {
       String nowUserName = (String)session.getAttribute("username");

       List<Friend> friends = friendService.getAllAddFriend(nowUserName, 1);

       model.addAttribute("friends", friends);

       return "HouAllFriend";
   }

   @RequestMapping("/toBeSomebodyFan/{fansName}")
   public String toBeSomebodyFan(@PathVariable("fansName") String fansName, HttpSession session) {

       System.out.println("fansName:"+fansName);
       String nowUserName = (String)session.getAttribute("username");

       fansService.addMeToSomebodyFan(nowUserName, fansName);

       return "redirect:/allFriend/1";
   }

   @RequestMapping("/getAllMyFans")
    public String getAllMyFans(HttpSession session, Model model) {

       String nowUserName = (String)session.getAttribute("username");

       List<Fans> Fanss = fansService.getAllMyFans(nowUserName);

       List<friendOrNot> friendOrNotList = new ArrayList<friendOrNot>();


       for (Fans f: Fanss) {

           if (nowUserName.equals(f.getMainFriendName())==false) {
               friendOrNot friendOrNotNow = new friendOrNot();
               System.out.println(f);
               friendOrNotNow.setNowUserName(nowUserName);
               friendOrNotNow.setFriendName(f.getMainFriendName());

               List<Fans> fansList = fansService.isFansOrNot(nowUserName, f.getMainFriendName());

               if (fansList.size()==0) {
                   friendOrNotNow.setFansOrNot(0);
               }
               else {
                   friendOrNotNow.setFansOrNot(1);
               }
               friendOrNotList.add(friendOrNotNow);
           }

       }

       for (friendOrNot f: friendOrNotList) {
           System.out.println(f);
       }

       model.addAttribute("friendOrNotList", friendOrNotList);

        return "allMyFans";

   }

   @RequestMapping("/cancelToBeSomebodyFan/{fansName}")
    public String cancelToBeSomebodyFan(HttpSession session, @PathVariable("fansName") String fansName) {

        String nowUserName = (String)session.getAttribute("username");

        fansService.cancelToBeSomebodyFan(nowUserName, fansName);

        return "redirect:/allFriend/1";
   }

    @RequestMapping("/MycancelToBeSomebodyFan/{fansName}")
    public String MycancelToBeSomebodyFan(HttpSession session, @PathVariable("fansName") String fansName) {

        String nowUserName = (String)session.getAttribute("username");

        fansService.cancelToBeSomebodyFan(nowUserName, fansName);

        return "redirect:/getAllMyFans";
    }

    @RequestMapping("/MytoBeSomebodyFan/{fansName}")
    public String MytoBeSomebodyFan(@PathVariable("fansName") String fansName, HttpSession session) {

        System.out.println("fansName:"+fansName);
        String nowUserName = (String)session.getAttribute("username");

        fansService.addMeToSomebodyFan(nowUserName, fansName);

        return "redirect:/getAllMyFans";
    }

    @RequestMapping("/deleteMyFriend/{name1}/{name2}")
    public String deleteMyFriend(@PathVariable("name1") String name1, @PathVariable("name2") String name2) {

        friendService.deleteMyFriend(name1, name2);

        return "redirect:/allMyAddFriend";
    }
}
