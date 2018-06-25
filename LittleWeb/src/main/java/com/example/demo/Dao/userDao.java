package com.example.demo.Dao;

import com.example.demo.Entity.User;

import java.util.List;

/**
 * Created by ggg on 2018/5/28.
 * 管理用户
 */
public interface userDao {
    //返回所有u_name=name的用户信息
    public List<User> findUserByName(String name);
    //添加一个用户
    public void addUser(User user);

    public List<User> getAllUser();

    public int getAllUserNum();

    public List<User> getUserByLimitBeginAndNum(int begin, int num);
}
