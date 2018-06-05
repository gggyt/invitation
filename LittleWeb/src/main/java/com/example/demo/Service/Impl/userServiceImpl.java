package com.example.demo.Service.Impl;

import com.example.demo.Dao.userDao;
import com.example.demo.Entity.User;
import com.example.demo.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ggg on 2018/5/28.
 */
@Service
public class userServiceImpl implements userService {

    @Autowired
    private userDao userDao;
    @Override
    public List<User> findUserByName(String name) {
        List<User> users = new ArrayList<User>();
        users = userDao.findUserByName(name);
        return users;
    }

    @Override
    public void addUser(User user){
        userDao.addUser(user);
    }
}
