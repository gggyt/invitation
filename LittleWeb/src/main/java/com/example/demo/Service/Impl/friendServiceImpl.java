package com.example.demo.Service.Impl;

import com.example.demo.Dao.friendDao;
import com.example.demo.Entity.Friend;
import com.example.demo.Service.friendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ggg on 2018/6/16.
 */
@Service
public class friendServiceImpl implements friendService {

    @Autowired
    private friendDao friendDao;

    @Override
   public List<Friend> findFriendOrNotWithOther(String mainFriendName, String otherFriendName){
        return friendDao.findFriendOrNotWithOther(mainFriendName, otherFriendName);
    }

    @Override
    public void addFriendWithMe(String myUsername, String friendName, int friendOrNot){
       friendDao.addFriendWithMe(myUsername, friendName, friendOrNot);
    }

    @Override
    public List<Friend> getAllDontAgreeFriend(String nowUserName){
        return friendDao.getAllDontAgreeFriend(nowUserName);
    }

    @Override
    public void addSomeoneToFriend(String mainFriendName, String otherFriendName){
        friendDao.addSomeoneToFriend(mainFriendName, otherFriendName);
    }

    @Override
    public List<Friend> getAllAddFriend(String myUserName, int friendOrNot){
        return friendDao.getAllAddFriend(myUserName, friendOrNot);
    }

    @Override
    public void deleteMyFriend(String name1, String name2){
        friendDao.deleteMyFriend(name1, name2);
    }
}
