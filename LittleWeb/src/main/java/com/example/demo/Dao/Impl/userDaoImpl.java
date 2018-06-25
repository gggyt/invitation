package com.example.demo.Dao.Impl;

import com.example.demo.Dao.userDao;
import com.example.demo.Entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggg on 2018/5/28.
 */
@Repository
public class userDaoImpl implements userDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserByName(String name){
        List<User> users = new ArrayList<User>();
        users = userMapper.findUserByName(name);

        return users;
    }
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    @Override
    public int getAllUserNum(){
        return userMapper.getAllUserNum();
    }

    @Override
    public List<User> getUserByLimitBeginAndNum(int begin, int num){
        return userMapper.getUserByLimitBeginAndNum(begin, num);
    }
}
