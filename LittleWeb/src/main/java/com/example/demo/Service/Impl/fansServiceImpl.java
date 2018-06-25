package com.example.demo.Service.Impl;

import com.example.demo.Dao.fansDao;
import com.example.demo.Entity.Fans;
import com.example.demo.Service.fansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ggg on 2018/6/16.
 */
@Service
public class fansServiceImpl implements fansService {

    @Autowired
    private fansDao fansDao;

    @Override
    public List<Fans> isFansOrNot(String mainFriendName, String otherFriendName){
        return fansDao.isFansOrNot(mainFriendName, otherFriendName);
    }

    @Override
    public int getAllFansNum(String myUserName){
        return fansDao.getAllFansNum(myUserName);
    }

    @Override
    public void addMeToSomebodyFan(String mainFriendName, String otherFriendName){
        fansDao.addMeToSomebodyFan(mainFriendName, otherFriendName);
    }

    @Override
    public List<Fans> getAllMyFans(String myUserName){
        return fansDao.getAllMyFans(myUserName);
    }

    @Override
    public void cancelToBeSomebodyFan(String mainFriendName, String otherFriendName){
        fansDao.cancelToBeSomebodyFan(mainFriendName, otherFriendName);
    }
}
