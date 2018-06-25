package com.example.demo.mapper;

/**
 * Created by ggg on 2018/5/28.
 */

import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {

    List<User> findUserByName(String name);
    User findUserById(int id);
    void addUser(User user);

    List<User> getAllUser();

    int getAllUserNum();

    List<User> getUserByLimitBeginAndNum(@Param("begin") int begin, @Param("num") int num);
}