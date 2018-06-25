package com.example.demo.Dao;

import com.example.demo.Entity.Fans;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ggg on 2018/6/16.
 */
public interface fansDao {
    public List<Fans> isFansOrNot(String mainFriendName, String otherFriendName);
    public int getAllFansNum(String myUserName);
    public void addMeToSomebodyFan(String mainFriendName, String otherFriendName);
    public List<Fans> getAllMyFans(String myUserName);
    public void cancelToBeSomebodyFan(String mainFriendName, String otherFriendName);
}
