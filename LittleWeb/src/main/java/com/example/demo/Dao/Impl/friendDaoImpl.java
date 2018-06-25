package com.example.demo.Dao.Impl;

import com.example.demo.Dao.friendDao;
import com.example.demo.Entity.Friend;
import com.example.demo.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ggg on 2018/6/16.
 */
@Repository
public class friendDaoImpl implements friendDao {

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<Friend> findFriendOrNotWithOther(String mainFriendName, String otherFriendName){
        return friendMapper.findFriendOrNotWithOther(mainFriendName, otherFriendName);
    }

    @Override
    public void addFriendWithMe(String myUsername, String friendName, int friendOrNot){
        friendMapper.addFriendWithMe(myUsername, friendName, friendOrNot);
    }

    @Override
    public List<Friend> getAllDontAgreeFriend(String nowUserName){
        return friendMapper.getAllDontAgreeFriend(nowUserName);
    }

    @Override
    public void addSomeoneToFriend(String mainFriendName, String otherFriendName){
        friendMapper.addSomeoneToFriend(mainFriendName, otherFriendName);
    }

    @Override
    public List<Friend> getAllAddFriend(String myUserName, int friendOrNot){
        return friendMapper.getAllAddFriend(myUserName, friendOrNot);
    }

    @Override
    public void deleteMyFriend(String name1, String name2){
        friendMapper.deleteMyFriend(name1, name2);
    }
}
