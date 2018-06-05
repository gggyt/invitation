package com.example.demo.Service.Impl;

import com.example.demo.Dao.visitorDao;
import com.example.demo.Entity.Visitor;
import com.example.demo.Service.visitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ggg on 2018/5/29.
 */
@Service
public class visitorServiceImpl implements visitorService {

    @Autowired
    private visitorDao visitorDao;
    @Override
    public int findAllNum() {
        return visitorDao.findAllNum();
    }

    @Override
    public void insertVisitor(Visitor visitor){
        visitorDao.insertVisitor(visitor);
    }
}
