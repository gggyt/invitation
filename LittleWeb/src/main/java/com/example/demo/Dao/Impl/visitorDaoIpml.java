package com.example.demo.Dao.Impl;

import com.example.demo.Dao.visitorDao;
import com.example.demo.Entity.Visitor;
import com.example.demo.mapper.VisitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ggg on 2018/5/29.
 */
@Repository
public class visitorDaoIpml implements visitorDao {

    @Autowired
    private VisitorMapper visitorMapper;

    @Override
    public int findAllNum() {
        int num=visitorMapper.findAllNum();

        return num;
    }

    @Override
    public void insertVisitor(Visitor visitor){
        visitorMapper.insertVisitor(visitor);
    }
}
