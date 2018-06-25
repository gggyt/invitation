package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ggg on 2018/5/28.
 */
public interface userService {
    //返回所有u_name=name的用户信息
    public List<User> findUserByName(String name);
    //添加一个用户
    public void addUser(User user);

    public List<User> getAllUser();

    public int getAllUserNum();

    public List<User> getUserByLimitBeginAndNum(int begin, int num);
}
