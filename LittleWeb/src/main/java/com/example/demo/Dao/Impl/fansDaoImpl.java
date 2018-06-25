package com.example.demo.Dao.Impl;

import com.example.demo.Dao.fansDao;
import com.example.demo.Entity.Fans;
import com.example.demo.mapper.FansMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ggg on 2018/6/16.
 */
@Repository
public class fansDaoImpl implements fansDao {

    @Autowired
    private FansMapper fansMapper;

    @Override
    public List<Fans> isFansOrNot(String mainFriendName, String otherFriendName) {
        return fansMapper.isFansOrNot(mainFriendName, otherFriendName);
    }

    @Override
    public int getAllFansNum(String myUserName){
        return fansMapper.getAllFansNum(myUserName);
    }

    @Override
    public void addMeToSomebodyFan(String mainFriendName, String otherFriendName){
        fansMapper.addMeToSomebodyFan(mainFriendName, otherFriendName);
    }

    @Override
    public List<Fans> getAllMyFans(String myUserName){
        return fansMapper.getAllMyFans(myUserName);
    }

    @Override
    public void cancelToBeSomebodyFan(String mainFriendName, String otherFriendName){
        fansMapper.cancelToBeSomebodyFan(mainFriendName, otherFriendName);
    }
}
