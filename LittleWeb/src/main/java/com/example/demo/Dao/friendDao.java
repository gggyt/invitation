package com.example.demo.Dao;

import com.example.demo.Entity.Friend;

import java.util.List;

/**
 * Created by ggg on 2018/6/16.
 */
public interface friendDao {
    public List<Friend> findFriendOrNotWithOther(String mainFriendName, String otherFriendName);
    public void addFriendWithMe(String myUsername, String friendName, int friendOrNot);
    public List<Friend> getAllDontAgreeFriend(String nowUserName);
    public void addSomeoneToFriend(String mainFriendName, String otherFriendName);
    public List<Friend> getAllAddFriend(String myUserName, int friendOrNot);
    public void deleteMyFriend(String name1, String name2);
}
